package entidades;

public class Decode {
    private String instrucaoString;
    private Instrucao instrucao;
    private MIPS mips;

    public Decode(MIPS mips) {
        this.mips = mips;
    }

    public Instrucao execute() {
        if(instrucaoString.contains("addi") || instrucaoString.contains("add") ||
                instrucaoString.contains("sub") || instrucaoString.contains("subi")){
                setInstrucao(parserInstrucao(instrucaoString));
                return getInstrucao();
        }
        else if (instrucaoString.contains("noop")){
            return new Instrucao("Noop");

        }
        else if (instrucaoString.contains("loop")){


        } else if (instrucaoString.contains("beq")) {

        }
        else if (instrucaoString.contains("J")){

        }
        return null;
    }

    private Instrucao parserInstrucao(String instrucaoString){
        if (instrucaoString.contains("neg1")){
            instrucaoString = instrucaoString.replace("neg1", "-1");
            mips.memoria[10] = -1;  // Indica offset para primeiro ciclo de execução
        }
        if (instrucaoString.contains("one")){
           instrucaoString = instrucaoString.replace("one", "1");
            mips.memoria[10] = 1;
        }
        if (instrucaoString.contains("ten")){
            instrucaoString = instrucaoString.replace("ten", "10");
            mips.memoria[10] = 10;
        }

        if (instrucaoString.contains("R")){
            instrucaoString = instrucaoString.replace("R", "");
        }
        String[] fields = instrucaoString.split(" ");
        return new Instrucao(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]),
                Integer.parseInt(fields[3]));
    }

    public Instrucao getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(Instrucao instrucao) {
        this.instrucao = instrucao;
    }

    public void setInstrucaoString(String instrucaoString) {
        this.instrucaoString = instrucaoString;
    }

}
