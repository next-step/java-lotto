package step2.domain;

public class LottoGame {

    private UserPrice userPrice;
    private LottoSheet lottoSheet;
    private LottoGenerator lottoGenerator;

    public LottoGame(int userPrice) {
        this.userPrice = new UserPrice(userPrice);
        lottoSheet = new LottoSheet();
        lottoGenerator = new LottoGenerator(new RandomGenerableStrategy());
    }

    public void run() throws IllegalArgumentException {
        lottoSheet = new LottoSheet(lottoGenerator.generateLottos(userPrice));
    }

    public LottoGameResultDto getGameResult(WinningLotto winningLotto)
        throws IllegalArgumentException {

        return new LottoGameResult().getResult(lottoSheet, winningLotto, userPrice);
    }

    public LottoSheet getLottoSheet() {
        return lottoSheet;
    }
}
