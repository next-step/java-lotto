package lotto.view;

import lotto.domain.LottoTicketForm;
import lotto.domain.LottoTicketForms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private static final String PRICE_REQUEST = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_REQUEST = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_REQUEST = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_SEPARATOR = ", ";
    private static final String BONUS_NUMBER_REQUEST = "보너스 볼을 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static long inputPrice() {
        return receivePrice();
    }

    public static LottoTicketForms inputManualLotto() {
        System.out.println(MANUAL_LOTTO_COUNT_REQUEST);
        int manualLottoCount = Integer.parseInt(scanner.nextLine());
        System.out.println(MANUAL_LOTTO_REQUEST);
        List<LottoTicketForm> lottoTicketForms = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            lottoTicketForms.add(LottoTicketForm.of(getInts(scanner.nextLine())));
        }
        return LottoTicketForms.of(lottoTicketForms);
    }

    public static int[] inputWinningNumbers() {
        return receiveWinnerNumbers();
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST);
        return scanner.nextInt();
    }

    private static long receivePrice() {
        System.out.println(PRICE_REQUEST);
        long price = Long.parseLong(scanner.nextLine());
        verifyPrice(price);
        return price;
    }

    private static void verifyPrice(long participates) {
        if (participates < 0) {
            throw new IllegalArgumentException(String.format("가격은 음수(%d)를 입력할 수 없습니다.", participates));
        }
    }

    private static int[] receiveWinnerNumbers() {
        System.out.println(WINNING_NUMBERS_REQUEST);
        String winningNumbersInput = scanner.nextLine();
        verifyWinningNumbersInput(winningNumbersInput);
        return getInts(winningNumbersInput);
    }

    private static int[] getInts(String winningNumbersInput) {
        String[] split = winningNumbersInput.split(WINNING_NUMBERS_SEPARATOR);
        return Stream.of(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void verifyWinningNumbersInput(String winningNumbersInput) {
        if (winningNumbersInput == null || winningNumbersInput.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }
}
