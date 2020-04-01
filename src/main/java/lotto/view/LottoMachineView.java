package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

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


    public static LottoTicket latestWinningLotto() {
        System.out.println(WINNING_LOTTO_INFO_MESSAGE);
        return new LottoTicket(
                Arrays.stream(split(LOTTO_SPLIT_DELIMITER))
                        .map(number -> number.trim())
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList())
        );
    }

    public static LottoResult checkWinningResult(LottoTicket lottoWinningTicket, LottoTickets lottoTickets) {
        return LottoMachine.winningResult(lottoWinningTicket, lottoTickets);
    }

    private static String[] split(String delimiter) {
        return sc.nextLine().split(delimiter);
    }
}
