package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int inputMoney, LottoPickStrategy lottoPickStrategy) {
        if (inputMoney < 1000)
            throw new IllegalArgumentException("로또 최소가격은 1000원 입니다");

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

    public LottoWinners match(List<Integer> pickLottoNumberOfWeek, int bonusBall) {
        LottoWinners lottoWinners = new LottoWinners();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.matching(pickLottoNumberOfWeek, bonusBall);
            lottoWinners.addWiners(rank);
        }

        return lottoWinners;
    }
}
