import interaction.InputView;
import interaction.OutputView;
import lotto.LottoNumbers;
import lotto.generator.BonusLottoGenerator;
import lotto.store.Ticket;

public class BonusLottoGameManager extends LottoGameManager {

    private BonusLottoGameManager() {
        super();
    }

    public static void main(String[] args) {
        LottoGameManager manager = new BonusLottoGameManager();
        manager.start();
    }

    @Override
    public void start() {
        Ticket lottPurchaseTicket = purchaseLotto();
        OutputView.sendMessage(lottPurchaseTicket.toString());
        LottoNumbers winningLotto = winningLotto();
        calculate(lottPurchaseTicket, winningLotto);
    }

    @Override
    protected LottoNumbers winningLotto() {
        String winningLottoMessage = InputView.winningLottoNumberMessage();
        int bonusNumber = InputView.bonusNumberMessage();
        BonusLottoGenerator generator = new BonusLottoGenerator(winningLottoMessage, bonusNumber);
        return generator.generate();
    }
}
