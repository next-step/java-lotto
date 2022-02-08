package lotto;

public class LottoAuto {
    
    public void play() {
        LottoRules lottoRules = new LottoRules();
        int lottoCount = InputView.getPrice() / lottoRules.LOTTO_PRICE;
        User user = new User(
          OutputView.getLottoCount(lottoCount), lottoRules);
        OutputView.printLottos(user.getLottos());
        WinningNumber winningNumber = new WinningNumber(InputView.getWinningNumber(), lottoRules);
        winningNumber.setBonusBall(InputView.getBonusBall());
        user.setRanks(winningNumber);
        double reward = OutputView.printResult(user.getRanks());
        OutputView.printYield(LottoRules.calculateYield(reward, user.getCount()));
    }
}
