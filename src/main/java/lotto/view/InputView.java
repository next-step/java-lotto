package lotto.view;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String REGEX = ", ";

    public static int getLottoMoney() {
        System.out.println(Message.LOTTO_MONEY.message);
        return scanner.nextInt();
    }

    public static int getNumberOfManualLottoTicket() {
        System.out.println(Message.NUMBER_OF_MANUAL_LOTTO_TICKET.message);
        return scanner.nextInt();
    }

    public static List<List<Integer>> getManualLottoNumbers(int numberOfManualLottoTicket) {
        System.out.println(Message.MANUAL_LOTTO_NUMBER.message);

        scanner.nextLine();
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (int i=0; i<numberOfManualLottoTicket; i++) {
            String manualLottoNumber = scanner.nextLine();
            manualLottos.add(getCommonLottoNumbers(manualLottoNumber));
        }
        return manualLottos;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(Message.WINNING_NUMBER.message);
        String winningLottoNumber = scanner.nextLine();
        return getCommonLottoNumbers(winningLottoNumber);
    }

    public static int getBonusBall() {
        System.out.println(Message.BONUS_BALL.message);
        return scanner.nextInt();
    }

    public static List<Integer> getCommonLottoNumbers(String winningLottoNumber) {
        return Arrays.stream(winningLottoNumber.split(REGEX))
                .map(InputView::toInt)
                .collect(Collectors.toList());
    }

    private static int toInt(String inputNumbers) {
        if (!StringUtils.isNumeric(inputNumbers)) {
            throw new IllegalArgumentException(Message.NOT_INTEGER.message);
        }
        return Integer.parseInt(inputNumbers);
    }
}
