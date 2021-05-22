package lottoauto;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.println("구입금액을 입력해 주세요.");
        int money = inputView.nextInt();

        LottoStore lottoStore = new LottoStore();

        User user = new User(money);
        List<LottoTicket> lottoTickets = user.buyLottoTickets(lottoStore);

        for(LottoTicket lottoTicket: lottoTickets) {
            outputView.print(lottoTicket);
            outputView.print("\n");
        }
    }
}
