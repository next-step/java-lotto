package lotto.view;

import lotto.domain.LottoNumber;

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
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getNumberOfManualLottoTicket() {
        System.out.println(Message.NUMBER_OF_MANUAL_LOTTO_TICKET.message);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> getManualLottoNumbers(int numberOfManualLottoTicket) {
        System.out.println(Message.MANUAL_LOTTO_NUMBER.message);

        List<String> manualLottos = new ArrayList<>();
        for (int i = 0; i < numberOfManualLottoTicket; i++) {
            manualLottos.add(scanner.nextLine());
        }
        return manualLottos;
    }

    public static List<LottoNumber> getWinningNumbers() {
        System.out.println(Message.WINNING_NUMBER.message);
        String winningLottoNumber = scanner.nextLine();
        return getCommonLottoNumbers(winningLottoNumber);
    }

    public static int getBonusBall() {
        System.out.println(Message.BONUS_BALL.message);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<LottoNumber> getCommonLottoNumbers(String winningLottoNumber) {
        return Arrays.stream(winningLottoNumber.split(REGEX))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
