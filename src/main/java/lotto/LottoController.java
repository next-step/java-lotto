package lotto;

import lotto.common.LottoInputParser;
import lotto.domian.*;
import lotto.ui.InputHandler;
import lotto.ui.OutputHandler;

public class LottoController {
    private final OutputHandler output;
    private final InputHandler input;
    private final LottoShop lottoShop;

    private LottoController(OutputHandler output, InputHandler input, LottoShop lottoShop) {
        this.output = output;
        this.input = input;
        this.lottoShop = lottoShop;
    }

    public static LottoController of(OutputHandler output, InputHandler input, LottoShop lottoShop){
        return new LottoController(output,input,lottoShop);
    }

    public void run() {
        int money = input.inputMoney();
        PurchaseAmount amount = PurchaseAmount.of(money);
        LottoTickets tickets = lottoShop.generateLottoTickets(money);
        output.printTickets(tickets);

        String winnerNum = input.inputWinnerNumber();
        output.printWinnerNumber(winnerNum);

        LottoNumber bonus = LottoNumber.of(input.inputBonusNumber());
        WinnerNumber winnerNumber = WinnerNumber.of(LottoInputParser.parseToIntegers(winnerNum), bonus);

        LottoResult result = LottoResult.initializeLottoResult();
        tickets.updateLottoResult(winnerNumber, result);
        long totalWinningAmount = result.calculateTotalWinningAmount();

        output.printResultHeader();
        output.printResult(result);
        output.printEarningsRate(amount, totalWinningAmount);
        input.closeScanner();
    }
}
