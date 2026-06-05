public class Time {
    private String nome;
    private int pontos;
    private int golsFeitos;
    private int golsSofridos;

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public int getSaldoGols() {
        return golsFeitos - golsSofridos;
    }

    public void adicionarGols(int feitos, int sofridos) {
        golsFeitos += feitos;
        golsSofridos += sofridos;
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }
}