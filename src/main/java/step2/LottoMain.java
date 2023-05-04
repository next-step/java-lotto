package step2;

public class LottoMain {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        lottoManager.buyLotto();
        lottoManager.showWinningLotto();
        lottoManager.getLottoResult();
        lottoManager.calculateLottoResult();
    }
}
