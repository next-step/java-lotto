package lotto.domain;

import lotto.domain.dto.LottoCalculationDTO;

public class LottoCalculation {

    private final Lottos purchaseLottos;

    public LottoCalculation(){
        this(new Lottos());
    }

    public LottoCalculation(Lottos lottos) {
        purchaseLottos = lottos;
    }

    public LottoCalculationDTO purchaseLottos(final Money money, final Lottos lottos){
        int numberOflottoManual = lottos.lottos().size();
        purchaseLottos.add(lottos);
        int numberOfLottoAutomatical = getNumberOfLottosAutomatical(money, numberOflottoManual);
        purchaseLottos.add(LottoBundle.lottoBundle(numberOfLottoAutomatical, new ShuffleLottoNumber()));
        return new LottoCalculationDTO(numberOflottoManual, numberOfLottoAutomatical, lottos);

    }

    private int getNumberOfLottosAutomatical(Money money, int numberOflottosManual) {
        return money.lottoCalculation() - numberOflottosManual;
    }


}
