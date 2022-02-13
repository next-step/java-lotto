package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Ticket;
import lotto.domain.WinningNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ENTER = "\n";
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String PURCHASE_TICKET_MANAGER_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_TICKET_MANAGER_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_TICKET_COUNT_ERROR_LOG = "수동으로 구매할 로또 수는 전체 금액을 초과할 수 없습니다.";
    private static final String MANUAL_TICKET_NUMBER_MANAGER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_MANAGER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MANAGER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final String INPUT_IS_EMPTY_ERROR_LOG = "공백은 들어올 수 없습니다.";
    private static final String LOTTO_NUMBER_SIZE_ERROR_LOG = "로또는 " + LOTTO_NUMBER_SIZE + "자리여야 합니다.";

    public static Ticket buyTicket() {
        int money = Integer.parseInt(writePurchaseAmount());
        return new Ticket(money);
    }

    private static String writePurchaseAmount() {
        try {
            OutputView.printMessage(PURCHASE_TICKET_MANAGER_MESSAGE + ENTER);
            String input = scanner.nextLine();
            checkEmptyString(input);
            return input;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return writePurchaseAmount();
        }
    }

    public static List<Lotto> buyManualLotto(int totalCount) {
        try {
            int manualTicketCount = buyManualTicket();
            validateManualCount(manualTicketCount, totalCount);
            return makeManualLottos(manualTicketCount);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return buyManualLotto(totalCount);
        }
    }

    private static void validateManualCount(int manualCount, int totalCount) {
        if (manualCount > totalCount) {
            throw new IllegalArgumentException(MANUAL_TICKET_COUNT_ERROR_LOG);
        }
    }

    private static int buyManualTicket() {
        try {
            OutputView.printMessage(ENTER + MANUAL_TICKET_MANAGER_MESSAGE + ENTER);
            String input = scanner.nextLine();
            checkEmptyString(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return buyManualTicket();
        }
    }

    private static List<Lotto> makeManualLottos(int manualTicketCount) {
        OutputView.printMessage(ENTER + MANUAL_TICKET_NUMBER_MANAGER_MESSAGE + ENTER);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualTicketCount; i++) {
            lottos.add(makeManualLotto());
        }
        return lottos;
    }

    private static Lotto makeManualLotto() {
        try {
            String input = scanner.nextLine();
            checkEmptyString(input);

            String[] numbers = makeStringToArray(input);
            checkSixNumbers(numbers);

            return Lotto.from(Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::new)
                .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return makeManualLotto();
        }
    }

    public static WinningNumber makeWinningNumber() {
        try {
            return new WinningNumber(makeSixNumbers(), makeBonusBall());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return makeWinningNumber();
        }
    }

    private static Lotto makeSixNumbers() {
        return Lotto.from(InputView.writeWinningNumbers());
    }

    private static LottoNumber makeBonusBall() {
        return new LottoNumber(InputView.writeBonusBall());
    }

    public static List<Integer> writeWinningNumbers() {
        try {
            OutputView.printMessage(WINNING_NUMBER_MANAGER_MESSAGE +ENTER);
            String input = scanner.nextLine();
            checkEmptyString(input);

            String[] numbers = makeStringToArray(input);
            checkSixNumbers(numbers);

            return Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::new)
                .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return writeWinningNumbers();
        }
    }

    private static int writeBonusBall() {
        try {
            OutputView.printMessage(BONUS_BALL_MANAGER_MESSAGE + ENTER);
            String input = scanner.nextLine();
            checkEmptyString(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return writeBonusBall();
        }
    }

    private static String[] makeStringToArray(String input) {
        return input.split(DELIMITER);
    }

    private static void checkEmptyString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY_ERROR_LOG);
        }
    }

    private static void checkSixNumbers(String[] input) {
        if (input.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_LOG);
        }
    }
}
