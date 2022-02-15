import domain.LottoPrice;
import domain.LottoService;
import domain.LottoTickets;

public class Application {

    public static void main(String[] args) {
        LottoService lotto = new LottoService();

        LottoPrice lottoPrice = lotto.inputPrice();
        LottoTickets lottoTickets = lotto.purchase(lottoPrice);
        lotto.showAllLottoTickets(lottoTickets);
        lotto.getRatioByAnswer(lottoTickets, lottoPrice);
    }
}
