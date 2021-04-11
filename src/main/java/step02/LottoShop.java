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
        LottoResultDTO resultDTO = new LottoResultDTO();

        Ranks ranks = lottos.compareMatchNumber(lottoWinner);
        resultDTO.setRanks(ranks);
        resultDTO.setYield(LottoPrice.calculateTotalReward(price, ranks));

        return resultDTO;
    }
}
