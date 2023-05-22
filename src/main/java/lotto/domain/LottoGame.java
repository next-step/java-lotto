package lotto.domain;

import lotto.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private static final String LOTTO_PRICE_ERROR_MESSAGE = "로또 구입 금액은 1000원 이상이어야 합니다.";

    private int gameCount;

    public LottoGame(final int buyMoney) {
        validate(buyMoney);
        gameCount = calcGameCount(buyMoney);
    }

    private void validate(final int buyMoney) {
        if (buyMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE_ERROR_MESSAGE);
        }
    }

    private static int calcGameCount(final int buyMoney) {
        return buyMoney / LOTTO_PRICE;
    }

    public Lottos automaticLottoDraw(final LottoStrategy lottoStrategy, final List<Lotto> lottoList) {
        return new Lottos(lottoStrategy, gameCount, lottoList);
    }

    public Lottos manualLottoDraw(int numberOfManualCount, final List<List<Integer>> manualLottoNumbers) {
        updateGameCount(numberOfManualCount);

        List<Lotto> manualLottoList = new ArrayList<>();

        for (int i = 0; i < numberOfManualCount; i++) {
            Lotto lotto = new Lotto(manualLottoNumbers.get(i));
            manualLottoList.add(lotto);
        }

        return new Lottos(manualLottoList);
    }

    private void updateGameCount(final int manualLottoCount) {
        gameCount -= manualLottoCount;
    }

}
