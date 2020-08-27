package step2.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static step2.domain.Validator.validateFormula;
import static step2.domain.Validator.validateLottoRangeNumber;
import static step2.domain.Validator.validateProofOfAmount;

public class InputView {

    public static final String PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요.";
    public static final String BONUS_NUMBER_MSG = "보너스 볼 번호를 입력해 주세요.";
    public static final String PREVIOUS_NUMBER_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String MANUAL_GAMES_COUNT_MSG = "수동으로 구매할 로또 수를 입력해 주세요";
    public static final String MANUAL_GAMES_MSG = "수동으로 구매할 번호를 입력해 주세요.";
    public static final int AMOUNT_OF_UNITS = 1000;

    public static int getPurchaseAmount() {
        printAnnounceMsg(PURCHASE_AMOUNT_MSG);
        return validateProofOfAmount(getInputNumber()) / AMOUNT_OF_UNITS;
    }

    public static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getInputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printAnnounceMsg(String announcementMessage) {
        System.out.println(announcementMessage);
    }

    public static String getPreviousNumber() {
        printAnnounceMsg(PREVIOUS_NUMBER_MSG);
        return validateFormula(getInputString());
    }

    public static int getBonusNumber() {
        printAnnounceMsg(BONUS_NUMBER_MSG);
        return validateLottoRangeNumber(getInputNumber());
    }

    public static int getTotalManualGameCount() {
        printAnnounceMsg(MANUAL_GAMES_COUNT_MSG);
        return validateLottoRangeNumber(getInputNumber());
    }

    public static List<String> getManualGame(int totalManualGameCount) {
        printAnnounceMsg(MANUAL_GAMES_MSG);
        return Arrays.asList()
                     .stream()
                     .map(s -> getInputString())
                     .collect(Collectors.toCollection(() -> new ArrayList<>(totalManualGameCount)));
    }
}
