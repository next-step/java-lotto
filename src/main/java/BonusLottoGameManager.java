import interaction.InputView;
import interaction.OutputView;
import lotto.LottoNumbers;
import lotto.generator.BonusLottoGenerator;
import lotto.store.Ticket;

public class BonusLottoGameManager extends LottoGameManager {

    protected BonusLottoGameManager() {
        super();
    }

    public static void main(String[] args) {
        LottoGameManager manager = new BonusLottoGameManager();
        manager.start();
    }

    @Override
    public void start() {
        Ticket lottoPurchaseTicket = purchaseLotto();
        OutputView.sendMessage(lottoPurchaseTicket.toString());
        LottoNumbers winningLotto = winningLotto();
        calculate(lottoPurchaseTicket, winningLotto);
    }

    @Override
    protected LottoNumbers winningLotto() {
        String winningLottoMessage = InputView.winningLottoNumberMessage();
        int bonusNumber = InputView.bonusNumberMessage();
        BonusLottoGenerator generator = new BonusLottoGenerator(winningLottoMessage, bonusNumber);
        return generator.generate();
    }
}
