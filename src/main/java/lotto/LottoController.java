package lotto;

import lotto.common.LottoInputParser;
import lotto.domian.LottoResult;
import lotto.domian.LottoShop;
import lotto.domian.LottoTickets;
import lotto.domian.WinnerNumber;
import lotto.ui.InputHandler;
import lotto.ui.OutputHandler;

public class LottoController {
    private final OutputHandler output;
    private final InputHandler input;
    private final LottoShop lottoShop;
    private final LottoInputParser parser;

    private LottoController(OutputHandler output, InputHandler input, LottoShop lottoShop, LottoInputParser parser) {
        this.output = output;
        this.input = input;
        this.lottoShop = lottoShop;
        this.parser = parser;
    }

    public static LottoController of(OutputHandler output, InputHandler input, LottoShop lottoShop, LottoInputParser parser){
        return new LottoController(output,input,lottoShop,parser);
    }

    public void run() {
        int money = input.inputMoney();
        LottoTickets tickets = lottoShop.generateLottoTickets(money);
        output.printTickets(tickets);

        String winnerNum = input.inputWinnerNumber();
        output.printWinnerNumber(winnerNum);
        WinnerNumber winnerNumber = WinnerNumber.of(parser.parseToIntegers(winnerNum));

        LottoResult result = LottoResult.initializeLottoResult();
        tickets.updateLottoResult(winnerNumber, result);

        output.printResultHeader();
        output.printResult(result);
        output.printEarningsRate(result, money);
        input.closeScanner();
    }
}
