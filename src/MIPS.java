public class MIPS {
    private int[] registradores = new int[32];
    private int[] memoria = new int[1024];
    private int pc;
    private int clockCycle;
    private String[] instrucoes;
    private InstrucaoBusca instrucaoIF;
    private InstrucaoDecode instrucaoID;
    private InstrucaoExecuta instrucaoEX;
    private InstrucaoMemoria instrucaoMEM;
    private InstrucaoEscreve instrucaoWB;

    public MIPS(String[] instructions) {
        this.instrucoes = instructions;
        pc = 0;
        instrucaoIF = new InstrucaoBusca(instrucoes);
        instrucaoID = new InstrucaoDecode();
        instrucaoEX = new InstrucaoExecuta();
        instrucaoMEM = new InstrucaoMemoria();
        instrucaoWB = new InstrucaoEscreve();
    }

    public void run() {
        while (pc < instrucoes.length || pipelineBusy()) {
            System.out.println("Clock Cycle: " + clockCycle);
            try {
                Thread.sleep(2000); // 2000 milissegundos = 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        instrucaoID.setInstrucao(instrucaoAtual);
    }

    private void decodifica() {
        String instrucaoAtual = instrucaoID.getInstrucao();
        instrucaoEX.setInstrucao(instrucaoAtual);
    }

    private void executa() {
        instrucaoEX.setInstrucao(instrucaoID.getInstrucao());
        instrucaoEX.execute();
    }

    private void acessoMemoria() {
        instrucaoMEM.setInstrucao(instrucaoEX.getInstrucao());
        instrucaoMEM.execute();
    }

    private void escreveRegistrador() {
        instrucaoWB.setInstrucao(instrucaoMEM.getInstrucao());
        instrucaoWB.execute();
    }

    private boolean pipelineBusy() {
        return false; // Implemente a lógica adequada aqui se necessário
    }

}