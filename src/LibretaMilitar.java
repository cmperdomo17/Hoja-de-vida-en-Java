public class LibretaMilitar {
    public enum TipoLibreta {
        PRIMERA, SEGUNDA
    }

    private TipoLibreta tipoLibreta;
    private float numeroLibreta;
    private int DM;

    public LibretaMilitar() {
    }

    public LibretaMilitar(TipoLibreta tipoLibreta, float numeroLibreta, int DM) {
        this.tipoLibreta = tipoLibreta;
        this.numeroLibreta = numeroLibreta;
        this.DM = DM;
    }

    public TipoLibreta getTipoLibreta() { return tipoLibreta; }

    public float getNumeroLibreta() { return numeroLibreta; }

    public int getDM() { return DM; }

    public void setTipoLibreta(String tipoLibreta) {
        try {
            this.tipoLibreta = TipoLibreta.valueOf(tipoLibreta);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de libreta no válido");
        }
    }

    public void setNumeroLibreta(float numeroLibreta) { this.numeroLibreta = numeroLibreta; }

    public void setDM(int DM) { this.DM = DM; }

}
