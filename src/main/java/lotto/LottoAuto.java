package lotto;

public class LottoAuto {

    public void play() {
        LottoRules lottoRules = new LottoRules();
        User user = new User(
          OutputView.getLottoCount(InputView.getPrice() / lottoRules.getLottoPrice()), lottoRules);
        OutputView.printLottos(user.getLottos());
        WinningNumber winningNumber = new WinningNumber(InputView.getWinningNumber(), lottoRules);
        winningNumber.setBonusBall(InputView.getBonusBall());
        user.setRanks(winningNumber);
        OutputView.printResult(user.getRanks(), user.getCount() * lottoRules.getLottoPrice());
    }
}
