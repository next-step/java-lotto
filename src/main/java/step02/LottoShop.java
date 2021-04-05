package step02;

public class LottoShop {
    private Lottos lottos;
    int money = 0;

    public Lottos buyLotto(NumberRule numberRule) throws Exception {
        money = InputView.inputMoney();
        lottos = new Lottos(LottoCount.calculationCount(money));
        lottos.makeLotto(numberRule);
        return lottos;
    }

    public LottoResultDTO showLottoResult() throws Exception {
        LottoNumbers lottoWinner = new LottoNumbers(new InputNumberRule(InputView.inputLastWinnerNumber()));
        LottoResultDTO resultDTO = lottos.compareMatchNumber(lottoWinner);
        resultDTO.setYield(Rank.calculateTotalReward(money, resultDTO));

        return resultDTO;
    }
}
