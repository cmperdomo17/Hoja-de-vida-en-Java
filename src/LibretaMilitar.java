public class LibretaMilitar {
    public enum TipoLibreta {
        PRIMERA, SEGUNDA
    }

    private TipoLibreta tipoLibreta;
    private int numeroLibreta;
    private int DM;

    public LibretaMilitar(TipoLibreta tipoLibreta, int numeroLibreta, int DM) {
        this.tipoLibreta = tipoLibreta;
        this.numeroLibreta = numeroLibreta;
        this.DM = DM;
    }

    public TipoLibreta getTipoLibreta() { return tipoLibreta; }

    public int getNumeroLibreta() { return numeroLibreta; }

    public int getDM() { return DM; }

    public void setTipoLibreta(String tipoLibreta) {
        try {
            this.tipoLibreta = TipoLibreta.valueOf(tipoLibreta);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de libreta no válido");
        }
    }

    public void setNumeroLibreta(int numeroLibreta) { this.numeroLibreta = numeroLibreta; }

    public void setDM(int DM) { this.DM = DM; }

    @Override
    public String toString() {
        return "LibretaMilitar{" +
                "tipoLibreta=" + tipoLibreta +
                ", numeroLibreta=" + numeroLibreta +
                ", DM=" + DM +
                '}';
    }

}
