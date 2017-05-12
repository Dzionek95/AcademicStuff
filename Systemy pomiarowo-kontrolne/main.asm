// Zadanie Z02

// Rejestry, operacje arytmetyczne, skoki bezwarunkowe i warunkowe, I/O
// Zadania:
// 1. Zapoznać się z działaniem programu
// 2. Uruchomić program w środowisku AVR Studio.
// Prześledzić działanie programu za pomocą
// debuggera, użyć pułapek (breakpoint) oraz
// funkcji wykonywania krokowego itp
// 3. [1 pkt] Mając do dyspozycji makro DELAY_1ms
// (czas wykonania dla zegara 8 MHz wynosi ok. 2 ms)
// napisz makro DO_DELAY (w pliku Z02.asm),
// które realizuje opóźnienie wykonania programu
// o podaną jako argument makra liczbę milisekund.
// W parach: napisać program służący do dwukierunkowej komunikacji
// szeregowej. Naciskając wybrany (1 z 4) przycisk w jednym module
// rozpoczyna się transmisja trzech bajtów danych. Pierwszy bajt określa
// operację arytmetyczną do wykonania w drugim module, np.:
// 1 - mnożenie,
//
// 3 - dodawanie,
// 4 - odejmowanie;
// pozostałe dwa bajty to operandy (jedna ze zmiennych zwiększana
// za każdym naciśnięciem o 1, zmienne przechowywane w pamięci RAM).
// Drugi moduł odbierający dane dodaje/odejmuje/mnoży otrzymane liczby,
// a wynik zapisany w RAM wyświetla na 8 diodach LED.
// 4. [0.5 pkt] Napisać funkcję odczytującą numer wciśniętego przycisku (debouncing!)
// 5. [0.75 + 0.75 pkt] Napisać funkcję do transmisji
// (wysyłanie/odbieranie - Send_Byte/Receive_Byte) danych
// szeregowych (8 bitów).
// Napisać funkcję do obsługi transmisji (wysyłanie oraz odbieranie
// pakietów danych 3-bajtowych - Send_Packet/Receive_Packet).
// 6. [0.75 + 0.75 pkt] Napisać funckję zwiększającą o 1 zmienną w pamięci RAM,
// a następnie wysyłającą pakiet danych (operacja, zmienna1, zmienna2).
// Napisać funkcję obsługującą odebrany pakiet 3 bajtów - wykonanie operacji,
// zapisanie wyniku do RAM, wyświetlenie wyniku.
// 7. [0.5 pkt] Zorganizowanie głównej pętli programu (MAIN).
 
.include "m16def.inc"
.include "utils.inc"
 
.def TEMP_0 = r16
.def TEMP_1 = r17
.def TEMP_2= r18
.def TEMP_3= r19
.def TEMP_4=r20
.def TEMP_5=r21
.def TEMP_6=r22
.def TEMP_A = r24
.def TEMP_B = r25


.equ DELAY_TIME = 500 // czas w ms
.equ DELAY_TIME2= 1500
.equ MNOZ = 1
.equ DODAJ = 3
.equ ODEJMIJ = 4
.equ FALSE = 0
.equ TRUE = 1

.cseg
 
.org 0
    rjmp RESET
 
.org INT_VECTORS_SIZE
 

 
 
.macro DO_DELAY
    push TEMP_A
    push TEMP_B
 
    ldi  TEMP_B, HIGH(@0)
    ldi TEMP_2, 0x01
    and TEMP_2, TEMP_B
    lsr TEMP_B
    ldi TEMP_A,  LOW(@0)
    lsr TEMP_A
    cpi TEMP_2, 0x01
    BREQ isTrue
    jmp end
    isTrue:
    ORI TEMP_A, 0x80
    end:
 
    //LSR TEMP_B
    //ROR TEMP_A
 
DELAY_LOOP:
    DELAY_2ms
    sbiw TEMP_B:TEMP_A, 1
    brne DELAY_LOOP
 
    pop TEMP_B
    pop TEMP_A
.endmacro

receiveBytes:
		ldi TEMP_4, 7		
	
	LOOP:
		in TEMP_0, PINA
		cpi TEMP_0, 0x00
		brne LOOP

    	//DO_DELAY DELAY_TIME2
		ldi TEMP_5, 0
		ldi TEMP_1, 0
		in TEMP_6, PINA
	 LOOP1:

		or TEMP_1, TEMP_6
		lsl TEMP_1	
		//DO_DELAY DELAY_TIME
		in TEMP_6, PINA
		subi TEMP_4, 1
		cpi TEMP_4, 0
		brne LOOP1	
		or TEMP_1, TEMP_6	
			
		out PORTB, TEMP_1 

	//DO_DELAY DELAY_TIME2
		ldi TEMP_4, 7
		ldi TEMP_6, 0
		

		ldi TEMP_2, 0
		in TEMP_6, PINA
	LOOP2:
		
		or TEMP_2, TEMP_6
		lsl TEMP_2
		//DO_DELAY DELAY_TIME
		in TEMP_6, PINA
		subi TEMP_4, 1
		cpi TEMP_4, 0
		brne LOOP2	
		or TEMP_2, TEMP_6

		out PORTB, TEMP_2
	//DO_DELAY DELAY_TIME2
		ldi TEMP_4, 7
		ldi TEMP_6, 0

		ldi TEMP_3,0
		in TEMP_6, PINA
	LOOP3:
		
		or TEMP_3, TEMP_6
		lsl TEMP_3
		//DO_DELAY DELAY_TIME
		in TEMP_6, PINA
		subi TEMP_4, 1
		cpi TEMP_4, 0
		brne LOOP3			
		or TEMP_3, TEMP_6

		out PORTB, TEMP_3
ret

doSthWithBytes:	
	//ldi TEMP_1, 3
	//ldi TEMP_2, 1
	//ldi TEMP_3, 1
	//TEST

	cpi TEMP_1, MNOZ
	breq multiplication
	cpi TEMP_1, DODAJ
	breq addition
	cpi TEMP_1, ODEJMIJ
	breq subtraction

	multiplication:
		mul TEMP_2, TEMP_3
		jmp end
	addition:
		add TEMP_2, TEMP_3
		jmp end
	subtraction:
		sub TEMP_2, TEMP_3
		jmp end
	end:
		out PORTB, TEMP_2
ret
 
 
 
RESET:
    INIT_STACK
    INIT_PORTS
    DISABLE_JTAG
 

    ser r16
    sts RxByte, r16
 
MAIN:
	rcall receiveBytes
    rcall doSthWithBytes

rjmp MAIN
 
Send_Byte:
    lds r16, RxByte
ret 
.dseg
RxByte: .byte 1
ArgA: .byte 1
ArgB: .byte 1
Oper: .byte 1
.eseg
b: .byte 1