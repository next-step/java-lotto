package lottery.view;

import lottery.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static Money inputPrice() {
        System.out.println("구매금액을 입력해 주세요");

        return Money.valueOf(nextInt());
    }

    public static List<LotteryTicket> inputSelectTickets() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        TicketCount count = TicketCount.valueOf(nextInt());

        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        return IntStream.range(0, count.getAmount())
                .mapToObj(i -> LotteryTicket.generate(sc.nextLine()))
                .collect(Collectors.toList());
    }

    public static WinningTicket inputWinningTicket() {
        return new WinningTicket(inputWinningNumbersTicket(), inputBonusNumber());
    }

    private static LotteryTicket inputWinningNumbersTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        LotteryTicket result = LotteryTicket.generate(sc.nextLine());
        System.out.println();

        return result;
    }

    private static LotteryNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        LotteryNumber result = LotteryNumber.of(nextInt());
        System.out.println();

        return result;
    }

    private static int nextInt() {
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }
}
