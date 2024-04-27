// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] instructions = {
                "lw 0 1 neg1",
                "lw 0 2 ten",
                "lw 0 3 one",
                "noop",
                "loop  add 2 1 2",
                "noop",
                "noop",
                "beq 2 0 done",
                "beq 0 0 loop",
                "done  halt",
                "neg1  .fill -1",
                "ten   .fill 10",
                "one   .fill 1"
        };
        MIPS simulator = new MIPS(instructions);
        simulator.run();
    }
}