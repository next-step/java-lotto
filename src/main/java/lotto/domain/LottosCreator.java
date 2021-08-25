package lotto.domain;

import lotto.exception.InputError;

import java.util.ArrayList;
import java.util.List;

public class LottosCreator {
    private static final Money LOTTO_PRICE = new Money(1000);

    private final int lottoCount;

    public LottosCreator(final Money lottoPurchasePrice, int manualLottoCount) {
        this.lottoCount = lottoPurchasePrice.divideBy(LOTTO_PRICE);
        if (lottoCount <= 0) {
            throw new InputError("로또를 구매할 수 없는 금액입니다.");
        }
        if (lottoCount < manualLottoCount) {
            throw new InputError("로또를 구매할 수 있는 갯수를 초과했습니다.");
        }
    }

    public Lottos createLottos(final List<String> manualLottos, final LottoNumbersCreator randomNumberCreator) {
        List<Lotto> lottos = new ArrayList<>();
        for (String manualLotto : manualLottos) {
            lottos.add(new Lotto(new ManualNumbersCreator(manualLotto).createNumbers()));
        }
        for (int i = 0; i < lottoCount - manualLottos.size(); i++) {
            lottos.add(new Lotto(randomNumberCreator.createNumbers()));
        }
        return new Lottos(lottos);
    }
}
