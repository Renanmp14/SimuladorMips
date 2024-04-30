package entidades;

public class Decodifica {
    private String instrucaoString;
    private Instrucao instrucao;
    private MIPS mips;

    public Decodifica(MIPS mips) {
        this.mips = mips;
    }

    public Instrucao run() {
        Instrucao instrucao = null;

        if(instrucaoString.contains("addi") || instrucaoString.contains("subi")) {
            instrucao = parserInstrucao(instrucaoString);
        }
        else if (instrucaoString.contains("noop")) {
            instrucao = new Instrucao("Noop");

        }
        else if (instrucaoString.contains("loop") || instrucaoString.contains("add") ||
                instrucaoString.contains("sub")) {
            instrucao = parserInstrucao(instrucaoString);

        } else if (instrucaoString.contains("beq")) {
            instrucao = parserInstrucao(instrucaoString);

        } else if (instrucaoString.contains("halt")) {
            instrucao = new Instrucao("halt");
        }
        setInstrucao(instrucao);
        return getInstrucao();
    }

    private Instrucao parserInstrucao(String instrucaoString){
        if (instrucaoString.contains("beq") && instrucaoString.contains("done")){
            String[] fields = instrucaoString.split(" ");
            return new Instrucao(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.MAX_VALUE);

        }
        if (instrucaoString.contains("beq") && instrucaoString.contains("loop")){
            String[] fields = instrucaoString.split(" ");
            return new Instrucao(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), mips.memoria[11]);

        }
        if (instrucaoString.contains("R")){
            instrucaoString = instrucaoString.replace("R", "");
        }

        if (instrucaoString.contains("loop")){
            mips.memoria[11] = (mips.pc - 1);  //Armazena o pc do inicio do loop
            String[] fields = instrucaoString.split(" ");
            return new Instrucao(fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
                    Integer.parseInt(fields[4]));
        }

        if (instrucaoString.contains("neg1")){
            instrucaoString = instrucaoString.replace("neg1", "-1");
            mips.memoria[10] = -1;  // Indica uma posição da memoria do mips para armazenar o valor da "variável"
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
