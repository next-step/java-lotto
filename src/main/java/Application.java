import domain.LottoService;

public class Application {

    public static void main(String[] args) {
        LottoService lotto = new LottoService();

        lotto.purchaseLotto();
        lotto.showAllLottoTickets();
        lotto.receiveAnswerNumber();
        lotto.finishLotto();
    }
}
