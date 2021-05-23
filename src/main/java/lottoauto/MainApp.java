package lottoauto;

public class MainApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.println("구입금액을 입력해 주세요.");
        Money money = new Money(inputView.nextInt());

        LottoStore lottoStore = new LottoStore();

        User user = new User(money);
        user.buyLottoTickets(lottoStore);

        user.printLottoTickets(outputView);


        outputView.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbersContents = inputView.next();

        LottoNumbers winningNumbers = new LottoNumbers(winningNumbersContents);

        user.checkHitCount(winningNumbers);
        user.printHitCount(outputView);
    }
}
