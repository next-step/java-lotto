package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int inputMoney, LottoPickStrategy lottoPickStrategy) {
        int lottoNum = inputMoney / Lotto.price;
        for (int i = 0; i < lottoNum; i++) {
            lottos.add(new Lotto(lottoPickStrategy));
        }
    }

    public int size() {
        return lottos.size();
    }

    public List<Integer> numbers(int index) {
        return lottos.get(index).pick();
    }

    public LottoWinners check(List<Integer> pickLottoNumberOfWeek) {
        LottoWinners lottoWinners = new LottoWinners();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matching(pickLottoNumberOfWeek);
            lottoWinners.addWiners(matchCount);
        }

        return lottoWinners;
    }
}
