import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price / 1000; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }
}
