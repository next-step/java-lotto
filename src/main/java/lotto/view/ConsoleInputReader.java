package lotto.view;

import lotto.domain.LottoMoney;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputReader {

    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private static final Scanner scanner = new Scanner(System.in);

    private ConsoleInputReader() {
        throw new UnsupportedOperationException("Util 클래스의 인스턴스는 생성할 수 없습니다.");
    }

    public static LottoMoney readLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            final long value = Long.parseLong(scanner.nextLine());

            return new LottoMoney(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 정수여야 합니다.", e);
        }
    }

    public static List<Integer> readLottoValue() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        try {
            final String[] numbers = scanner.nextLine().split(LOTTO_NUMBER_DELIMITER);

            return Arrays.stream(numbers)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 `" + LOTTO_NUMBER_DELIMITER + "`로 구분하여 정수로 입력해야 합니다.", e);
        }
    }

    public static int readLottoNumberValue() {
        System.out.println("보너스 볼을 입력해 주세요.");

        try {
            final int number = Integer.parseInt(scanner.nextLine());
            System.out.println();

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 정수여야 합니다.", e);
        }
    }
}
