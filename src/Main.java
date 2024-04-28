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
                "noop",
                "done halt",
                "neg1 .fill -1",
                "ten .fill 10",
                "one .fill 1"
        };

        MIPS simulador = new MIPS(instrucoes);
        simulador.run();
    }
}