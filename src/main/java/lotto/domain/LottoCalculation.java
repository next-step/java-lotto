package lotto.domain;

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

    public LottoCalculationDTO purchaseLottos(Lottos lottos) {
        int numberOflottoManual = lottos.lottos().size();

        purchaseLottos.add(lottos);
        int numberOfLottoAutomatical = getNumberOfLottosAutomatical(numberOflottoManual);
        purchaseLottos.add(
            LottoBundle.lottoBundle(numberOfLottoAutomatical, new ShuffleLottoNumber()));

        return new LottoCalculationDTO(numberOflottoManual, numberOfLottoAutomatical,
            purchaseLottos);

    }

    private int getNumberOfLottosAutomatical(int numberOflottosManual) {
        return calculateLotto() - numberOflottosManual;
    }

    public int calculateLotto() {
        return purchaseMoney.getValue() / LOTTO_PRICE;
    }
}
