package entidades;

public class MIPS {
    int[] registradores = new int[31];
    int[] memoria = new int[1024];
    int pc;
    private int contadorInstrucoes;
    String[] instrucoes;
    private Decodifica instrucaoID;
    private Executa instrucaoEX;
    private Memoria instrucaoMEM;
    private Escreve instrucaoWB;
    boolean halt;

    public MIPS(String[] instructions) {
        this.instrucoes = instructions;
        pc = 0;
        instrucaoID = new Decodifica(this);
        instrucaoEX = new Executa(this);
        instrucaoMEM = new Memoria(this);
        instrucaoWB = new Escreve(this);
        halt = false;
    }

    public void run() {
        while (!instrucaoWB.isHalt()) {
            if (contadorInstrucoes == 0){
                System.out.println("Simulador iniciado, instruções finalizadas: " + contadorInstrucoes);
                buscaInstrucao();
                decodifica();
                executa();
                acessoMemoria();
                escreveRegistrador();
                contadorInstrucoes++;
            }else {
                System.out.println("Instruções finalizadas: " + contadorInstrucoes);
                escreveRegistrador();
                contadorInstrucoes++;
            }

        }
        System.out.println("Instruções finalizadas: " + contadorInstrucoes);
        System.out.println("Fim do processo");
    }

    private void buscaInstrucao() {
        if (pc < instrucoes.length){
            String instrucaoAtual = instrucoes[pc];
            instrucaoID.setInstrucaoString(instrucaoAtual);
            pc++;

        }else {
            halt = true;  //Terminou as instruções, logo, encaminha o processador para o término da execução
            instrucaoID.setInstrucaoString("halt");
            pc++;
        }

    }

    private void decodifica() {
        instrucaoID.execute();
        instrucaoEX.setInstrucao(instrucaoID.getInstrucao());
        buscaInstrucao();
    }

    private void executa() {
        instrucaoEX.execute();
        instrucaoMEM.setInstrucao(instrucaoEX.getInstrucao());

        decodifica();
    }

    private void acessoMemoria() {
        instrucaoMEM.execute();
        instrucaoWB.setInstrucao(instrucaoMEM.getInstrucao());
        instrucaoWB.setData(instrucaoMEM.getData());
        instrucaoMEM.setData(0);

        executa();
    }

    private void escreveRegistrador() {
        instrucaoWB.execute();
        instrucaoWB.setData(0);
        acessoMemoria();
    }

}