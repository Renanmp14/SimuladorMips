package programa;

import entidades.MIPS;

public class Main {
    public static void main(String[] args) {
        String[] instrucoes = {
                "addi R0 R1 neg1",
                "addi R0 R2 ten",
                "addi R0 R3 one",
                "noop",
                "loop add 2 1 2",
                "noop",
                "noop",
                "beq 2 0 done",
                "noop",
                "noop",
                "noop",
                "beq 0 0 loop",
                "noop",
                "noop",
                "noop"
        };

        /*
                "addi R0 R1 neg1",
                "addi R0 R2 ten",
                "addi R0 R3 one",
                "noop",
                "loop add 2 1 2",
                "noop",
                "noop",
                "beq 2 0 done",
                "noop",
                "noop",
                "noop",
                "beq 0 0 loop",
                "noop",
                "noop",
                "noop"
         */

        MIPS simulador = new MIPS(instrucoes);
        simulador.run();

    }
}