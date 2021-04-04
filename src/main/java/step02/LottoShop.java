package step02;

public class LottoShop {
    private Lottos lottos;
    private LottoWinner lottoWinner;

    public Lottos buyLotto(RandomNumberRule makeRandomNumberRule) throws Exception {
        lottos = new Lottos(LottoCount.calculationCount(InputView.inputMoney()));
        lottos.makeLotto(makeRandomNumberRule);
        return lottos;
    }

    public void showLottoResult() throws Exception {
        LottoWinner lottoWinner = new LottoWinner(new InputNumberRule(InputView.inputLastWinnerNumber()));
    }

}
