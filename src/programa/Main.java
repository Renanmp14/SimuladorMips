package programa;

import entidades.MIPS;

public class Main {
    public static void main(String[] args) {
        String[] instrucoes = {
                "noop",
                "noop",
                "addi R0 R1 neg1",
                "addi R0 R2 ten"
        };

        MIPS simulador = new MIPS(instrucoes);
        simulador.run();
        System.out.println("Fim do processo");
    }
}