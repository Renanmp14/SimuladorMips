package programa;

import entidades.MIPS;

public class Main {
    public static void main(String[] args) {
        String[] instrucoes = {
                "addi R0 R1 -1"
        };

        MIPS simulador = new MIPS(instrucoes);
        simulador.run();
    }
}