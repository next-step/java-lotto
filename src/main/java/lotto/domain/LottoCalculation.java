package lotto.domain;

import java.util.List;
import lotto.domain.dto.LottoCalculationDTO;

public class LottoCalculation {

    private static final int LOTTO_PRICE = 1000;

    private Lottos purchaseLottos;
    private Money purchaseMoney;

    public LottoCalculation(Money value) {
        this(new Lottos(), value);
    }

    public LottoCalculation(Lottos lottos, Money money) {
        purchaseMoney = money;
        purchaseLottos = lottos;
    }

    public Lottos getPurchaseLottos() {
        return purchaseLottos;
    }

    public LottoCalculationDTO purchaseLottos(List<Lotto> lotto) {
        int numberOfLottoManual = lotto.size();

        purchaseLottos.add(new Lottos(lotto));
        int numberOfLottoAutomatical = getNumberOfLottosAutomatical(numberOfLottoManual);
        purchaseLottos.add(
            LottoBundle.lottoBundle(numberOfLottoAutomatical, new ShuffleLottoNumber()));

        return new LottoCalculationDTO(numberOfLottoManual, numberOfLottoAutomatical,
            purchaseLottos);

    }

    private int getNumberOfLottosAutomatical(int numberOfLottoManual) {
        return calculateLotto() - numberOfLottoManual;
    }

    public int calculateLotto() {
        return purchaseMoney.getValue() / LOTTO_PRICE;
    }
}
