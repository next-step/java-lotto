package step02;

public class LottoShop {
    private Lottos lottos;
    private LottoPrice price;

    public LottosDTO buyLotto(NumberRule numberRule) {
        price = new LottoPrice(InputView.inputMoney());
        lottos = new Lottos(LottoPrice.calculationCount(price));
        lottos.makeLotto(numberRule);
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
