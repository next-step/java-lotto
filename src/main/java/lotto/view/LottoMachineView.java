package lotto.view;

import lotto.domain.*;
import lotto.exception.MinimumPurchaseAmountException;
import lotto.util.LottoTicketUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoMachineView {
    private static final String PURCHASE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_INFO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_SPLIT_DELIMITER = ",";

    private static final Scanner sc = new Scanner(System.in);

    public static void show(List<Integer> showTicketNumber) {
        System.out.println(showTicketNumber.toString());
    }

    public static LottoTickets lottoPurchaseView() {
        System.out.println(PURCHASE_MESSAGE);
        String purchaseAmount = sc.nextLine();
        return new LottoMachine().purchaseTicket(purchaseAmount);
    }

    public static void showTicketNumber(LottoTickets lottoTickets) {
        for (LottoTicket ticket : lottoTickets.ticketList()) {
            LottoMachineView.show(ticket.showTicketNumber());
        }
    }

    public static LottoWinningTicket latestWinningLotto() {
        System.out.println(WINNING_LOTTO_INFO_MESSAGE);
        return new LottoWinningTicket(
                Arrays.stream(split(LOTTO_SPLIT_DELIMITER))
                        .map(number -> number.trim())
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList())
        );
    }

    public static LottoResult checkWinningResult(LottoWinningTicket lottoWinningTicket, LottoTickets lottoTickets) {
        return LottoMachine.winningResult(lottoWinningTicket, lottoTickets);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 1; i < LottoPrize.values().length; i++) {
            LottoPrize prize = LottoPrize.values()[i];
            System.out.print(String.format("%d개 일치", prize.getMatchCount()));
            System.out.print(String.format(" (%d원)", prize.getPrice()));
            System.out.println(String.format(" - %d개", lottoResult.prizeCount(prize)));
        }
        System.out.println(String.format("총 수익률은 %.2f", lottoResult.average()));
    }




    private static String[] split(String delimiter) {
        return sc.nextLine().split(delimiter);
    }
}
