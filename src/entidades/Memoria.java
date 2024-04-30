package entidades;

public class Memoria {
    private Instrucao instrucao;
    private MIPS mips;
    private int data;

    public Memoria(MIPS mips) {
        this.mips = mips;
    }

    public void run() {
        if (instrucao.getOPCode().contains("addi") || instrucao.getOPCode().contains("add") ||
                instrucao.getOPCode().contains("sub") || instrucao.getOPCode().contains("subi")) {
            data = mips.memoria[0];
            mips.memoria[0] = 0;
        }else if(instrucao.getOPCode().contains("beq")){
            data = mips.memoria[19]; // Recebe ou não a instrução de término
            mips.memoria[19] = 0;
        }
    }

    public Instrucao getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(Instrucao instrucao) {
        this.instrucao = instrucao;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
