package entidades;

public class Instrucao {
    private String OPCode;
    private int operando1;
    private int operando2;
    private int operando3;

    public Instrucao(String OPCode, int operando1, int operando2, int operando3) {
        this.OPCode = OPCode;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operando3 = operando3;
    }

    public Instrucao(String OPCode) {
        this.OPCode = OPCode;
    }

    public String getOPCode() {
        return OPCode;
    }

    public void setOPCode(String OPCode) {
        this.OPCode = OPCode;
    }

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public int getOperando3() {
        return operando3;
    }

    public void setOperando3(int operando3) {
        this.operando3 = operando3;
    }
}
