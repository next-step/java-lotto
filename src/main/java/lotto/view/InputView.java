package lotto.view;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_MESSAGE_LOTTO_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_NUMBER_OF_MANUAL_LOTTO_TICKET = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MESSAGE_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    public static final String REGEX = ", ";

    public static int getLottoMoney() {
        System.out.println(INPUT_MESSAGE_LOTTO_MONEY);
        return scanner.nextInt();
    }

    public static int getNumberOfManualLottoTicket() {
        System.out.println(INPUT_MESSAGE_NUMBER_OF_MANUAL_LOTTO_TICKET);
        return scanner.nextInt();
    }

    public static List<List<Integer>> getManualLottoNumbers(int numberOfManualLottoTicket) {
        System.out.println(INPUT_MESSAGE_MANUAL_LOTTO_NUMBER);

        scanner.nextLine();
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (int i=0; i<numberOfManualLottoTicket; i++) {
            String manualLottoNumber = scanner.nextLine();
            manualLottos.add(getCommonLottoNumbers(manualLottoNumber));
        }
        return manualLottos;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(INPUT_MESSAGE_WINNING_NUMBER);
        String winningLottoNumber = scanner.nextLine();
        return getCommonLottoNumbers(winningLottoNumber);
    }

    public static int getBonusBall() {
        System.out.println(INPUT_MESSAGE_BONUS_BALL);
        return scanner.nextInt();
    }

    public static List<Integer> getCommonLottoNumbers(String winningLottoNumber) {
        return Arrays.stream(winningLottoNumber.split(REGEX))
                .map(InputView::toInt)
                .collect(Collectors.toList());
    }

    private static int toInt(String inputNumbers) {
        if (!StringUtils.isNumeric(inputNumbers)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return Integer.parseInt(inputNumbers);
    }
}
