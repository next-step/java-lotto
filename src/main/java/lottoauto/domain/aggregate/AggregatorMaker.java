package lottoauto.domain.aggregate;

import lottoauto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class AggregatorMaker {

    private static final int EACH_LOTTO_PRICE = 1000;

    private final CustomShuffle shuffle;

    public AggregatorMaker(CustomShuffle shuffle) {
        this.shuffle = shuffle;
    }

    public Aggregator makeAggregator(int lottoBuyMoney) {

        if (!isValidBuyPrice(lottoBuyMoney)) {
            throw new IllegalArgumentException("로또 구매 금액은 1000의 배수여야 합니다.");
        }

        int lottoCount = lottoBuyMoney / EACH_LOTTO_PRICE;

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(shuffle.makeShuffle()));
        }

        return new Aggregator(lottoList);
    }

    private boolean isValidBuyPrice(int lottoBuyMoney) {
        return lottoBuyMoney % EACH_LOTTO_PRICE == 0;
    }
}
