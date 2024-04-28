public class InstrucaoDecode {
    private String instrucao;

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void execute() {
        if(instrucao.contains("addi")){

        }
        else if (instrucao.contains("nopp")){
            String tarefa = "Pula Instrução";
        }
        else if (instrucao.contains("loop")){

        } else if (instrucao.contains("beq")) {

        }
        else if (instrucao.contains("J")){

        }
        else{
            System.out.println("Error");
        }
    }
}
