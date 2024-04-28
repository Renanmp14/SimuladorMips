public class InstrucaoDecode {
    private String instrucao;

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public String[] execute() {
        if(instrucao.contains("addi") || instrucao.contains("add") ||
                instrucao.contains("sub") || instrucao.contains("subi")){
            return instrucao.split("");
        }
        else if (instrucao.contains("noop")){
            String tarefa = "Pula Instrução";
            return null;
        }
        else if (instrucao.contains("loop")){
            return instrucao.split("");

        } else if (instrucao.contains("beq")) {

        }
        else if (instrucao.contains("J")){

        }
        else{
            System.out.println("Error");
        }
        return null;
    }


}
