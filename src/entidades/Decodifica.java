package entidades;

public class Decodifica {
    private String instrucaoString;
    private Instrucao instrucao;
    private MIPS mips;

    public Decodifica(MIPS mips) {
        this.mips = mips;
    }

    public Instrucao execute() {
        if(instrucaoString.contains("addi") || instrucaoString.contains("subi")){
                setInstrucao(parserInstrucao(instrucaoString));
                return getInstrucao();
        }
        else if (instrucaoString.contains("noop")){
            setInstrucao(new Instrucao("Noop"));
            return getInstrucao();

        }
        else if (instrucaoString.contains("loop") || instrucaoString.contains("add") ||
                instrucaoString.contains("sub")){
            setInstrucao(parserInstrucao(instrucaoString));
            return getInstrucao();

        } else if (instrucaoString.contains("beq")) {
            setInstrucao(parserInstrucao(instrucaoString));
            return getInstrucao();

        } else if (instrucaoString.contains("halt")) {
            setInstrucao(new Instrucao("halt"));
            return getInstrucao();
        }
        return null;
    }

    private Instrucao parserInstrucao(String instrucaoString){
        if (instrucaoString.contains("beq") && instrucaoString.contains("done")){
            String[] fields = instrucaoString.split(" ");
            return new Instrucao(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.MAX_VALUE);

        }
        if (instrucaoString.contains("R")){
            instrucaoString = instrucaoString.replace("R", "");
        }

        if (instrucaoString.contains("loop")){
            mips.memoria[11] = mips.pc; //Armazena o pc do inicio do loop
            String[] fields = instrucaoString.split(" ");
            return new Instrucao(fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
                    Integer.parseInt(fields[4]));
        }

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
