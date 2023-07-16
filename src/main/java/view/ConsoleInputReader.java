package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputReader implements InputReader {

    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public long readMoneyValue() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            final long money = Long.parseLong(scanner.nextLine());
            validateRange(money);

            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 정수여야 합니다.");
        }
    }

    @Override
    public List<Integer> readLottoValue() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        try {
            final String[] numbers = scanner.nextLine().split(LOTTO_NUMBER_DELIMITER);

            return Arrays.stream(numbers)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 `" + LOTTO_NUMBER_DELIMITER + "`로 구분하여 정수로 입력해야 합니다.");
        }
    }

    @Override
    public int readLottoNumberValue() {
        System.out.println("보너스 볼을 입력해 주세요.");

        try {
            final int number = Integer.parseInt(scanner.nextLine());
            System.out.println();

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 정수여야 합니다.");
        }
    }

    private void validateRange(final long money) {
        if (money <= 0) {
            throw new IllegalArgumentException("구입 금액은 양의 정수여야 합니다.");
        }
    }
}
