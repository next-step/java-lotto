package lottery.web.view;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;
import lottery.domain.Money;
import lottery.domain.WinningTicket;
import lottery.supplier.BoundedUniqueRandomNumbersGenerator;
import lottery.supplier.NumbersGenerator;
import spark.Request;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String LINE_SEPARATOR = "\r\n";

    public static Money inputPrice(Request req) {
        return Money.valueOf(Integer.parseInt(req.queryParams("inputMoney")));
    }

    public static List<LotteryTicket> inputSelectTickets(Request req) {
        return Arrays.stream(splitLine((req.queryParams("manualNumber"))))
                .map(line -> LotteryTicket.generate(line))
                .collect(Collectors.toList());
    }

    private static String[] splitLine(String lines) {
        return lines.split(LINE_SEPARATOR);
    }

    public static WinningTicket inputWinningTicket() {
        NumbersGenerator generator = new BoundedUniqueRandomNumbersGenerator(LotteryNumber.LOWER_BOUND_INCLUSIVE, LotteryNumber.UPPER_BOUND_INCLUSIVE);
        List<Integer> list = generator.nextNumbers(LotteryTicket.NUMBERS_COUNT + 1);


        LotteryTicket winningNumbersTicket = new LotteryTicket(list.stream()
                .limit(LotteryTicket.NUMBERS_COUNT)
                .collect(Collectors.toList()));

        LotteryNumber bonusNumber = LotteryNumber.of(list.get(list.size() - 1));
        return new WinningTicket(winningNumbersTicket, bonusNumber);
    }
}
