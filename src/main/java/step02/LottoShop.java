package step02;

public class LottoShop {
    private Lottos lottos;
    private LottoPrice price;

    public Lottos buyLotto(NumberRule numberRule) throws Exception {
        price = new LottoPrice(InputView.inputMoney());
        lottos = new Lottos(LottoPrice.calculationCount(price));
        lottos.makeLotto(numberRule);
        return lottos;
    }

    public LottoResultDTO showLottoResult() throws Exception {
        LottoNumbers lottoWinner = new LottoNumbers(new InputNumberRule(InputView.inputLastWinnerNumber()));
        LottoResultDTO resultDTO = lottos.compareMatchNumber(lottoWinner);
        resultDTO.setYield(LottoPrice.calculateTotalReward(price, resultDTO));

        return resultDTO;
    }
}
