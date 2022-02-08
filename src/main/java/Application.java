import domain.LottoPrice;
import domain.LottoService;
import domain.LottoTickets;

public class Application {

    public static void main(String[] args) {
        LottoService lotto = new LottoService();

        LottoPrice lottoPrice = lotto.inputPrice();
        LottoTickets lottoTickets = lotto.purchaseManualLotto(lottoPrice);
        lotto.purchaseAutoLotto(lottoTickets, lottoPrice);
        lotto.getRatioByAnswer(lottoTickets, lottoPrice);
    }
}
