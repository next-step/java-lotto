import view.LottoInputView;

public class LottoMain {

    public static void main(String[] args) {
        int money = LottoInputView.getMoney();
        LottoController lottoController = new LottoController();
        lottoController.playLottoGames(money);
        lottoController.getLottoResults();
        lottoController.getWinningStatistics();
    }
}
