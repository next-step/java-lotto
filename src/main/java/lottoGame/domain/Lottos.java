package lottoGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private List<Lotto> lottoList = new ArrayList<>();

    public Lottos(int autoBuyCount) {
        for (int i = 0; i < autoBuyCount; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
    }

    public Lottos(List<List<Integer>> manualLottos, int autoBuyCount) {
        this(autoBuyCount);
        IntStream.range(0, manualLottos.size()).forEach(i -> lottoList.add(new Lotto(manualLottos.get(i))));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottoList = lottos;
    }

    public int buyCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
