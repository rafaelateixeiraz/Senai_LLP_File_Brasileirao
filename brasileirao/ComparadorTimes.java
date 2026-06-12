import java.util.Comparador;

public class ComparatorTimes implements Comparador<Time> {

    @Override
    public int compare(Time t1, Time t2) {

        if (t2.getPontos() != t1.getPontos()) {
            return t2.getPontos() - t1.getPontos();
        }

        return t2.getSaldoGols() - t1.getSaldoGols();
    }
}
