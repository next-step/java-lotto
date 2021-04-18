package step02.model.lotto;

import step02.dto.LottoResultDTO;
import step02.dto.LottosDTO;
import step02.model.numberRule.InputNumberRule;
import step02.model.rank.Ranks;
import step02.ui.InputView;

public class LottoShop {
    private Lottos lottos;
    private LottoPrice price;

    public LottosDTO buyLotto() {
        price = new LottoPrice(InputView.inputMoney());

        lottos = new Lottos();

        lottos.setLottoCount(price.calculationCount());
        lottos.makeManualLotto();
        lottos.makeAutomaticLotto();

        return lottos.getLottoResult();
    }

    public LottoResultDTO showLottoResult() {
        LottoNumbers lottoWinner = new LottoNumbers(new InputNumberRule(InputView.inputLastWinnerNumber()));
        LottoResultDTO resultDTO = new LottoResultDTO();
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusBall());

        Ranks ranks = lottos.compareMatchNumber(lottoWinner, bonusNumber);
        resultDTO.setRanks(ranks);
        resultDTO.setYield(LottoPrice.calculateTotalReward(price, ranks));

        return resultDTO;
    }
}
