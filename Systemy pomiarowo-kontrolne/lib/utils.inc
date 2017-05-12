.macro INIT_STACK
	ldi r16, LOW(RAMEND)
	out SPL, r16
	ldi r16, HIGH(RAMEND)
	out SPH, r16
.endmacro

.macro INIT_PORTS
	//	port B jako wyjœcie
	ser r16
	out DDRB, r16

	//	port A jako wejœcie z pull-up
	out PORTA, r16
	clr r16
	out DDRA, r16

	//  diody zapalaj¹ siê w logice odwrotnej (H -> zgaszona, L -> zapalona)
	ser r16
	out PORTB, r16
.endmacro

.macro DISABLE_JTAG
    ldi r16,(1 << JTD)
    out MCUCSR, r16
    out MCUCSR, r16
.endmacro

.equ DELAY_2ms_CNT = 1066	// dziala tylko dla 8 MHz zegara
.macro DELAY_2ms
	push TEMP_A
	push TEMP_B

    ldi TEMP_A,  LOW(DELAY_2ms_CNT)
    ldi TEMP_B, HIGH(DELAY_2ms_CNT)
DELAY_2ms_LOOP:
    nop 
	nop nop nop
	nop nop nop nop
	nop nop nop
    sbiw TEMP_B:TEMP_A, 1
    brne DELAY_2ms_LOOP

	pop TEMP_B
	pop TEMP_A
.endmacro
