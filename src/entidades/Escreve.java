package entidades;

import java.util.MissingFormatArgumentException;

public class Escreve {
    private Instrucao instrucao;
    private int data;
    private MIPS mips;

    public Escreve(MIPS mips) {
        this.mips = mips;
    }

    public void execute() {
        if (instrucao.getOPCode().contains("addi") || instrucao.getOPCode().contains("add") ||
                instrucao.getOPCode().contains("sub") || instrucao.getOPCode().contains("subi")) {
            mips.registradores[instrucao.getOperando1()] = data;
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
