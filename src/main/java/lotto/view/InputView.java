package lotto.view;

import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningLottoRequestDto;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String MONEY_NOT_NUMBER_MESSAGE = "구입 금액은 숫자여야 합니다. 숫자를 입력해주세요.";
    private static final String WINNING_NOT_NUMBER_MESSAGE = "당첨 번호는 숫자여야 합니다. 숫자를 입력해주세요.";
    private static final String BONUS_NOT_NUMBER_MESSAGE = "보너스 볼은 숫자여야 합니다. 숫자를 입력해주세요.";
    private final Scanner scanner = new Scanner(System.in);

    public MoneyRequestDto inputMoney() {
        return processInput(this::readMoney, MONEY_NOT_NUMBER_MESSAGE);
    }

    private MoneyRequestDto readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        long money = Long.parseLong(scanner.nextLine());
        return new MoneyRequestDto(money);
    }

    public WinningLottoRequestDto inputWinningLotto() {
        List<Integer> lottoNumbers = processInput(this::readWinningNumbers, WINNING_NOT_NUMBER_MESSAGE);
        int bonusNumber = processInput(this::readBonusNumber, BONUS_NOT_NUMBER_MESSAGE);
        System.out.println();
        return new WinningLottoRequestDto(lottoNumbers, bonusNumber);
    }

    private int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private List<Integer> readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        return Stream.of(numbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private <T> T processInput(Supplier<T> supplier, String message) {
        try {
            return supplier.get();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }
}
