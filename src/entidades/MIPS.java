package entidades;

public class MIPS {
    int[] registradores = new int[31];
    int[] memoria = new int[1024];
    private int pc;
    private int clockCycle;
    private String[] instrucoes;
    private Busca instrucaoIF;
    private Decode instrucaoID;
    private Executa instrucaoEX;
    private Memoria instrucaoMEM;
    private Escreve instrucaoWB;

    public MIPS(String[] instructions) {
        this.instrucoes = instructions;
        pc = 0;
        instrucaoIF = new Busca(instrucoes);
        instrucaoID = new Decode(this);
        instrucaoEX = new Executa(this);
        instrucaoMEM = new Memoria(this);
        instrucaoWB = new Escreve(this);
    }

    public void run() {
        while (pc < instrucoes.length) {
            System.out.println("Instruções finalizadas: " + clockCycle);
            buscaInstrucao();
            decodifica();
            executa();
            acessoMemoria();
            escreveRegistrador();
            clockCycle++;
        }
    }

    private void buscaInstrucao() {
        String instrucaoAtual = instrucoes[pc];
        pc++;
        instrucaoID.setInstrucaoString(instrucaoAtual);

    }

    private void decodifica() {
        instrucaoID.execute();
        instrucaoEX.setInstrucao(instrucaoID.getInstrucao());
        if (instrucoes.length < pc){
            buscaInstrucao();
        }
    }

    private void executa() {
        instrucaoEX.execute();
        instrucaoMEM.setInstrucao(instrucaoEX.getInstrucao());
        if (instrucoes.length < pc){
            decodifica();
        }
    }

    private void acessoMemoria() {
        instrucaoMEM.execute();
        instrucaoWB.setInstrucao(instrucaoMEM.getInstrucao());
        instrucaoWB.setData(instrucaoMEM.getData());
        if (instrucoes.length < pc) {
            executa();
        }
    }

    private void escreveRegistrador() {
        instrucaoWB.execute();
        if (instrucoes.length < pc) {
            acessoMemoria();
        }
    }

}