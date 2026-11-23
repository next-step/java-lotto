import java.util.ArrayList;
import java.util.List;

public class Lottos {


    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Lottos(int amount) {
        this(create(amount));
    }

    private static List<Lotto> create(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyLotto(amount); i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private static int buyLotto(int amount) {
        return amount / 1000;
    }

    public int size() {
        return lottoList.size();
    }
}
