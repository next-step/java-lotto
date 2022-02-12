package lotto.domain;

import lotto.domain.dto.LottoCalculationDTO;
import lotto.domain.dto.RankDTO;

public class LottoCalculation {

    private Lottos purchaseLottos;

    public LottoCalculation(){
        this(new Lottos());
    }

    public LottoCalculation(Lottos lottos) {
        purchaseLottos = lottos;
    }

    public LottoCalculationDTO purchaseLottos(final Money money, final Lottos lottos){
        int numberOflottoManual = lottos.lottos().size();

        purchaseLottos = purchaseLottos.add(lottos);
        int numberOfLottoAutomatical = getNumberOfLottosAutomatical(money, numberOflottoManual);
        purchaseLottos = purchaseLottos.add(LottoBundle.lottoBundle(numberOfLottoAutomatical, new ShuffleLottoNumber()));

        return new LottoCalculationDTO(numberOflottoManual, numberOfLottoAutomatical, purchaseLottos);

    }

    private int getNumberOfLottosAutomatical(Money money, int numberOflottosManual) {
        return money.lottoCalculation() - numberOflottosManual;
    }


    public RankDTO getCalculationLottoResult(RankResult rank, Money money){
        return new RankDTO(rank, money);
    }

}
