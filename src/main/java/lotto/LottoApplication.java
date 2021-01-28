package lotto;

import java.util.List;
import java.util.Map;
import lotto.controller.Validator;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.domain.Revenue;
import lotto.domain.Ticket;
import lotto.domain.WinningNumber;
import lotto.util.NumberUtils;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoApplication {

    public static void main(String[] args) {
        // 하드코딩
        Validator validator = new Validator();
        OutputHandler outputHandler = new OutputHandler();
        InputHandler inputHandler = new InputHandler();

        String money = inputHandler.requestPriceFromUser();
        if (!validator.isPriceValidate(money)) {
            outputHandler.printErrorPurchasePrice();
            System.exit(0);
        }
        Price price = new Price(Integer.parseInt(money));
        outputHandler.printLottoPurchaseCount(price.calculateTickets());
        List<Ticket> tickets = price.buyTickets();
        outputHandler.printGeneratedTickets(tickets);

        String winningNumberInput = inputHandler.requestWinningNumber();
        if (!validator.validateWinningNumber(winningNumberInput)) {
            outputHandler.printErrorWinningNumber();
            System.exit(0);
        }

        String bonusNumber = inputHandler.requestBonusNumber();
        if (!validator.validateBonusNumber(bonusNumber)) {
            outputHandler.printErrorBonusBall();
            System.exit(0);
        }

        // call winning number
        WinningNumber winningNumber = new WinningNumber(new Ticket(NumberUtils.convertStringToIntegerList(winningNumberInput)),
                                                        Integer.parseInt(bonusNumber));
        Lotto lotto = new Lotto(winningNumber, tickets);

        Map<Revenue, Integer> revenueCluster = lotto.statisticsTicket();
        outputHandler.printLottoStatics(revenueCluster);
        int total = lotto.calculateTotalPrize(revenueCluster);
        Double yield = NumberUtils.calculateYield(Integer.parseInt(money), total);
        outputHandler.printTotalRevenue(yield);
    }
}
