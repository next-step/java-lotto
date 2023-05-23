package step2.domain;

import step2.domain.Lotto.Lotto;
import step2.domain.Lotto.LottoBalls;
import step2.domain.Lotto.LottoNum;
import step2.domain.Lotto.LottoNums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Store {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> buyLotto(Amount amount) {
        List<Lotto> lottos = new ArrayList<>();
        int buyLottoCount = amount.getAmount() / LOTTO_PRICE;

        List<LottoNum> lottoBalls = new ArrayList<>(LottoBalls.balls);

        for (int i = 0; i < buyLottoCount; i++) {
            Collections.shuffle(lottoBalls);
            LottoNums.Builder lottoBuilder = new LottoNums.Builder();

            IntStream.rangeClosed(Constant.MIN_NUM, Constant.LOTTO_NUM_SIZE)
                    .forEach(num -> lottoBuilder.lottoNum(lottoBalls.get(num)));
            lottos.add(new Lotto(lottoBuilder.build()));
        }

        return lottos;
    }


}
