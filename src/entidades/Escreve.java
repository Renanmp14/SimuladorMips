package entidades;

public class Escreve {
    private Instrucao instrucao;
    private int data;
    private MIPS mips;
    private boolean halt;

    public Escreve(MIPS mips) {
        this.mips = mips;
        halt = false;
    }

    public void execute() {
        if (instrucao.getOPCode().contains("addi") || instrucao.getOPCode().contains("subi")) {
            mips.registradores[instrucao.getOperando2()] = data;
        }else if(instrucao.getOPCode().contains("add") || instrucao.getOPCode().contains("sub")){
            mips.registradores[instrucao.getOperando1()] = data;
        }else if(data == Integer.MAX_VALUE){
            mips.pc = mips.instrucoes.length;
        }else if(instrucao.getOPCode().contains("halt")){
            halt = true;
        }else if(instrucao.getOPCode().contains("beq") && data == mips.memoria[11]){
            mips.pc = mips.memoria[11];
            mips.memoria[11] = 0;
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

    public boolean isHalt() {
        return halt;
    }

    public void setHalt(boolean halt) {
        this.halt = halt;
    }
}
