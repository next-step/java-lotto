package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private final static int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(int lottoCount, LottoGeneration lottoGeneration) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.create(lottoGeneration));
        }
    }

    public static int LOTTO_PRICE() {
        return LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }


    public long matchLottoCount(LottoPrize lottoPrize, Lotto prizeLotto) {
        return lottos.stream()
                .filter(item -> lottoPrize.equalsPrize(item.getCountMatchedLottoNumber(prizeLotto)))
                .count();

    }

    public int size() {
        return this.lottos.size();
    }

    public double getRateOfReturn(Lotto winnerLotto) {
        return getPrizeSum(winnerLotto) / (double) LOTTO_PRICE;
    }

    private long getPrizeSum(Lotto winnerLotto) {
        return this.lottos.stream()
                .filter(item -> item.getCountMatchedLottoNumber(winnerLotto) != null)
                .mapToLong(item -> item.getCountMatchedLottoNumber(winnerLotto).getPrize())
                .sum();
    }
}
