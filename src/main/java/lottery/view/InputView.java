package lottery.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTickets;
import lottery.domain.ManualTicketCount;
import lottery.domain.PurchasePrice;
import lottery.domain.WinningLotteryNumbers;

public class InputView {

    private static final Scanner STANDARD_INPUT_SCANNER = new Scanner(System.in);
    private static final String MESSAGE_PURCHASE_PRICE = "구매금액을 입력해 주세요.";
    private static final String MESSAGE_MANUAL_LOTTERY_COUNT = "수동으로 구매할 수를 입력해 주세요.";
    private static final String MESSAGE_MANUAL_LOTTERY_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MESSAGE_LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static PurchasePrice getPurchasePrice() {
        System.out.println(MESSAGE_PURCHASE_PRICE);

        final String input = STANDARD_INPUT_SCANNER.nextLine();
        final int price = Integer.parseInt(input);
        return PurchasePrice.from(price);
    }

    public static ManualTicketCount getManualLotteryCount(final PurchasePrice purchasePrice) {
        System.out.println(MESSAGE_MANUAL_LOTTERY_COUNT);

        final String input = STANDARD_INPUT_SCANNER.nextLine();
        final int manualLotteryCount = Integer.parseInt(input);

        return ManualTicketCount.from(manualLotteryCount, purchasePrice);
    }

    public static LotteryTickets getManualLotteryTickets(final ManualTicketCount manualTicketCount) {
        System.out.println(MESSAGE_MANUAL_LOTTERY_NUMBERS);
        List<LotteryTicket> tickets = IntStream.range(0, manualTicketCount.getValue())
            .mapToObj(idx -> getLotteryTicket())
            .collect(Collectors.toList());

        return LotteryTickets.create(tickets);
    }

    public static WinningLotteryNumbers getWinningLotteryNumbers() {
        return WinningLotteryNumbers.of(getWinningLottery(), getBonusNumber());
    }

    private static LotteryTicket getWinningLottery() {
        System.out.println(MESSAGE_LAST_WEEK_WINNING_NUMBERS);
        return getLotteryTicket();
    }

    private static LotteryTicket getLotteryTicket() {
        final String input = STANDARD_INPUT_SCANNER.nextLine();
        final List<Integer> lotteryNumbers = Arrays.stream(input.split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        return LotteryTicket.from(lotteryNumbers);
    }

    private static LotteryNumber getBonusNumber() {
        System.out.println(MESSAGE_BONUS_NUMBER);

        final String input = STANDARD_INPUT_SCANNER.nextLine();
        final int bonusNumber = Integer.parseInt(input);
        return LotteryNumber.from(bonusNumber);
    }
}
