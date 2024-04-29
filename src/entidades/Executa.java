package entidades;

public class Executa {
    private Instrucao instrucao;

    private MIPS mips;

    public Executa(MIPS mips) {
        this.mips = mips;
    }

    public void execute() {
        //Trazer as constantes até aqui para verificação
        if (instrucao.getOPCode().contains("addi") || instrucao.getOPCode().contains("add") ||
                instrucao.getOPCode().contains("sub") || instrucao.getOPCode().contains("subi") ) {
            int a = (instrucao.getOperando2() >= 0 && instrucao.getOperando2() < mips.registradores.length) ?
                    mips.registradores[instrucao.getOperando2()] : instrucao.getOperando2();
            int b = 0;
            if (mips.memoria[10] != 0){
            b = mips.memoria[10];
            mips.memoria[10] = 0;
            }else{
                b = (instrucao.getOperando3() >= 0 && instrucao.getOperando3() < mips.registradores.length) ?
                        mips.registradores[instrucao.getOperando3()] : instrucao.getOperando3();
            }

            int soma = (a+b);
            mips.memoria[0] = soma;
        }
    }

    public Instrucao getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(Instrucao instrucao) {
        this.instrucao = instrucao;
    }

}
