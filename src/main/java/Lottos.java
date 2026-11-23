import java.util.ArrayList;
import java.util.List;

public class Lottos {


    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Lottos(int amount) {
        int size = amount / 1000;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto());
        }

        lottoList = lottos;
    }

    public int size() {
        return lottoList.size();
    }
}
