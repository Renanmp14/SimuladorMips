import java.util.Arrays;

public class InstrucaoBusca {
    private String[] instrucoes;
    private int pc;
    private String[] instrucaoAtual;

    public InstrucaoBusca(String[] instrucoes) {
        this.instrucoes = instrucoes;
        this.pc = 0;
    }

    public String[] execute() {
        if (pc >= 0 && pc < instrucoes.length) {
            instrucaoAtual = instrucoes[pc].split(" ");
            pc++;
            return instrucaoAtual;
        } else {
            System.out.println("Nenhuma instrução para buscar. PC fora do intervalo.");
            return null;
        }
    }

    public String getOpcode() {
        if (instrucaoAtual != null && instrucaoAtual.length > 0) {
            return instrucaoAtual[0].toLowerCase();
        }
        return null;
    }

    public String[] getOperandos() {
        if (instrucaoAtual != null && instrucaoAtual.length > 1) {
            return Arrays.copyOfRange(instrucaoAtual, 1, instrucaoAtual.length);
        }
        return null;
    }
}
