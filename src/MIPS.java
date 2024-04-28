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
        instrucaoIF = new InstrucaoBusca();
        instrucaoID = new InstrucaoDecode();
        instrucaoEX = new InstrucaoExecuta();
        instrucaoMEM = new InstrucaoMemoria();
        instrucaoWB = new InstrucaoEscreve();
    }

    public void run() {
        while (pc < instrucoes.length || pipelineBusy()) {
            System.out.println("Clock Cycle: " + clockCycle);
            buscaInstrucao();
            decodifica();
            executa();
            acessoMemoria();
            escreveRegistrador();
            clockCycle++;
        }
    }

    private void buscaInstrucao() {
        instrucaoIF.setInstrucao(instrucoes[pc]);
        instrucaoIF.execute();
        pc++;
    }

    private void decodifica() {
        instrucaoID.setInstrucao(instrucaoIF.getInstrucao());
        instrucaoID.execute();
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

    // Classes internas para representar cada estágio do pipeline
}