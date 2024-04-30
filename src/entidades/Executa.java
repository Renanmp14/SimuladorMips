package entidades;

public class Executa {
    private Instrucao instrucao;

    private MIPS mips;

    public Executa(MIPS mips) {
        this.mips = mips;
    }

    public void run() {
        //Trazer as constantes até aqui para verificação
        if (instrucao.getOPCode().contains("addi") || instrucao.getOPCode().contains("subi") ) {
            int a = (instrucao.getOperando1() >= 0 && instrucao.getOperando1() < mips.registradores.length) ?
                    mips.registradores[instrucao.getOperando1()] : instrucao.getOperando1();
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
        }else if(instrucao.getOPCode().contains("add") || instrucao.getOPCode().contains("sub")){
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
        }else if(instrucao.getOPCode().contains("beq") && instrucao.getOperando3() == Integer.MAX_VALUE){
            int a = (instrucao.getOperando1() >= 0 && instrucao.getOperando1() < mips.registradores.length) ?
                    mips.registradores[instrucao.getOperando1()] : instrucao.getOperando1();
            int b = (instrucao.getOperando2() >= 0 && instrucao.getOperando2() < mips.registradores.length) ?
                    mips.registradores[instrucao.getOperando2()] : instrucao.getOperando2();
            if (a == b){
                mips.memoria[1023] = instrucao.getOperando3();
            }

        }else if(instrucao.getOPCode().contains("beq") && instrucao.getOperando3() == mips.memoria[11]){
            int a = (instrucao.getOperando1() >= 0 && instrucao.getOperando1() < mips.registradores.length) ?
                    mips.registradores[instrucao.getOperando1()] : instrucao.getOperando1();
            int b = (instrucao.getOperando2() >= 0 && instrucao.getOperando2() < mips.registradores.length) ?
                    mips.registradores[instrucao.getOperando2()] : instrucao.getOperando2();
            if (a == b){
                mips.memoria[1023] = instrucao.getOperando3();
            }

        }
    }

    public Instrucao getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(Instrucao instrucao) {
        this.instrucao = instrucao;
    }

}
