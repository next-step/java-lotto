package step2.domain;

public class LottoGame {

    private UserPrice userPrice;
    private LottoSheet lottoSheet;
    private LottoGenerator lottoGenerator;

    public LottoGame(UserPrice userPrice, LottoSheet manualLottoSheet) {
        this.userPrice = userPrice;
        lottoSheet = manualLottoSheet;
        if (manualLottoSheet == null) {
            lottoSheet = new LottoSheet();
        }
        lottoGenerator = new LottoGenerator(new RandomGenerableStrategy());
    }

    public void run() throws IllegalArgumentException {
        this.lottoSheet = lottoSheet.mergeLottoSheet(
            lottoGenerator.generateLottos(userPrice.getLottoCount() - lottoSheet.getLottoCount()));
    }

    public LottoGameResultDto getGameResult(WinningLotto winningLotto)
        throws IllegalArgumentException {

        return new LottoGameResult().getResult(lottoSheet, winningLotto, userPrice);
    }

    public LottoSheet getLottoSheet() {
        return lottoSheet;
    }
}
