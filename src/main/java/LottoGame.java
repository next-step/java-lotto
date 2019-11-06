import lotto.controller.LottoMarket;
import lotto.input.TerminalInputReader;
import lotto.view.TerminalViewer;

public class LottoGame {
    public static void main(String[] args) {
        LottoMarket lottoMarket = new LottoMarket(new TerminalInputReader() , new TerminalViewer());
        lottoMarket.guess();
    }
}
