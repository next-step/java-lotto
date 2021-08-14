package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoTicket;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_LOTTO_BUY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTOTICKET_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTOTICKETS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNER_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private String inputStringValue() {
        return scanner.nextLine();
    }

    private int inputIntValue() {
        int inputValue = scanner.nextInt();
        scanner.nextLine();
        return inputValue;
    }

    public int inputLottoBuyAmount() {
        System.out.println(INPUT_LOTTO_BUY_AMOUNT);
        int amount = Integer.parseInt(inputStringValue());
        if (amount < 1000) {
            throw new RuntimeException("1000원보다 큰 금액을 입력하세요.");
        }
        return amount;
    }

    public int inputManualLottoTicketCount() {
        System.out.println("\n" + INPUT_MANUAL_LOTTOTICKET_COUNT);
        return inputIntValue();
    }

    public List<LottoTicket> inputManualLottoTickets(int lottoTicketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        if (lottoTicketCount > 0) {
            System.out.println("\n" + INPUT_MANUAL_LOTTOTICKETS);
        }

        for (int i = 0; i < lottoTicketCount; i++) {
            int[] lottoTicketIntArray = getLottoTicketIntArray();
            lottoTickets.add(LottoTicket.of(lottoTicketIntArray));
        }
        return lottoTickets;
    }

    private int[] getLottoTicketIntArray() {
        return Arrays.stream(inputStringValue().split(",")).mapToInt(s -> Integer.parseInt(s.trim())).toArray();
    }

    public String inputLastWeekWinnerNumbers() {
        System.out.println("\n" + INPUT_LAST_WEEK_WINNER_NUMBERS);
        return inputStringValue();
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return inputIntValue();
    }

    public void scannerClose() {
        scanner.close();
    }
}
