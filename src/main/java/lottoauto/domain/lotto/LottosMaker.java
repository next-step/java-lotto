package lottoauto.domain.lotto;

import lottoauto.domain.aggregate.CustomShuffle;

import java.util.ArrayList;
import java.util.List;

public class LottosMaker {

    public static Lottos makeLottoList(CustomShuffle shuffle, int lottoBuyMoney) {

        if (!isValidBuyPrice(lottoBuyMoney)) {
            throw new IllegalArgumentException("로또 구매 금액은 1000의 배수여야 합니다.");
        }

        int lottoCount = lottoBuyMoney / Lottos.EACH_LOTTO_PRICE;

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(shuffle.makeShuffle()));
        }

        return new Lottos(lottoList);
    }

    private static boolean isValidBuyPrice(int lottoBuyMoney) {
        return lottoBuyMoney % Lottos.EACH_LOTTO_PRICE == 0;
    }
}
