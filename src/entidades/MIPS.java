package entidades;

public class MIPS {
    int[] registradores = new int[31];
    int[] memoria = new int[1024];
    int pc;
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
        while (clockCycle <= instrucoes.length) {
            if (clockCycle == 0){
                System.out.println("Simulador iniciado, instruções finalizadas: " + clockCycle);
                buscaInstrucao();
                decodifica();
                executa();
                acessoMemoria();
                escreveRegistrador();
                clockCycle++;
            }else if (clockCycle < instrucoes.length){
                System.out.println("Instruções finalizadas: " + clockCycle);
                escreveRegistrador();
                clockCycle++;
            }else {
                System.out.println("Instruções finalizadas: " + clockCycle);
                clockCycle++;
            }


        }
    }

    private void buscaInstrucao() {
        if (pc < instrucoes.length){
            String instrucaoAtual = instrucoes[pc];
            instrucaoID.setInstrucaoString(instrucaoAtual);
            pc++;

        }else {
            pc++;
        }

    }

    private void decodifica() {
        instrucaoID.execute();
        instrucaoEX.setInstrucao(instrucaoID.getInstrucao());
        if (instrucoes.length > clockCycle){
            buscaInstrucao();
        }
    }

    private void executa() {
        instrucaoEX.execute();
        instrucaoMEM.setInstrucao(instrucaoEX.getInstrucao());
        if (instrucoes.length > clockCycle){
            decodifica();
        }
    }

    private void acessoMemoria() {
        instrucaoMEM.execute();
        instrucaoWB.setInstrucao(instrucaoMEM.getInstrucao());
        instrucaoWB.setData(instrucaoMEM.getData());
        if (instrucoes.length > clockCycle) {
            executa();
        }
    }

    private void escreveRegistrador() {
        instrucaoWB.execute();
        if (instrucoes.length > clockCycle) {
            acessoMemoria();
        }
    }

}