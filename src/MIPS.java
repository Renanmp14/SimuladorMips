public class MIPS {
    private int[] registradores = new int[31];
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

        /*if(instrucaoAtual.contains("addi") || instrucaoAtual.contains("add") ||
                instrucaoAtual.contains("sub") || instrucaoAtual.contains("subi")){
                String[] fields = instrucaoAtual.split(" ");
                String OpCode = fields[0];
                registradores Integer.parseInt(fields[1].charAt(1));

                //TipoDaInstrução R
        }
        else if (instrucaoAtual.contains("noop")){
            String tarefa = "Pula Instrução";

        }
        else if (instrucaoAtual.contains("loop")){
                //TipoDaInstrução j

        } else if (instrucaoAtual.contains("beq")) {
                //TipoDaInstrução I
        }
        else if (instrucaoAtual.contains("J")){

        }
        else{
            System.out.println("Error");
        }
        */


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