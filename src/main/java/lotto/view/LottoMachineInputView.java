package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoMachineInputView {
    private static final String PURCHASE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_INFO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE ="보너스 번호를 입력해 주세요.";

    private static final String LOTTO_SPLIT_DELIMITER = ",";

    private static final Scanner sc = new Scanner(System.in);


    public static void show(Set<Integer> showTicketNumber) {
        System.out.println(showTicketNumber.toString());
    }

    public static int lottoPurchaseView() {
        System.out.println(PURCHASE_MESSAGE);
        return sc.nextLine();
    }

    public static List<Integer> latestWinningLotto() {
        System.out.println(WINNING_LOTTO_INFO_MESSAGE);
        String[] inputs = sc.nextLine().split(LOTTO_SPLIT_DELIMITER);
        return new ArrayList(Arrays.stream(inputs).
                map(input -> input.trim())
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }
    public static int bonusLottoNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
        return sc.nextInt();
    }
    public static LottoResult checkWinningResult(LottoTicket lottoWinningTicket, LottoTickets lottoTickets, int bonusNumber) {
        return LottoMachine.winningResult(lottoWinningTicket, lottoTickets, bonusNumber);
    }

    private static String[] split(String delimiter) {
        return sc.nextLine().split(delimiter);
    }
}
