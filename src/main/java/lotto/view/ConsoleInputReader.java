package lotto.view;

import lotto.domain.LottoCount;
import lotto.domain.LottoMoney;

import java.util.ArrayList;
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

    public static List<Integer> readWinningLottoValue() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return readLottoValue();
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

    public static LottoCount readLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            final long lottoCount = Long.parseLong(scanner.nextLine());

            return new LottoCount(lottoCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 개수는 정수여야 합니다.", e);
        }
    }

    public static List<List<Integer>> readManualLottoContents(final long maxCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<List<Integer>> manualLottoContents = new ArrayList<>();
        for (int count = 0; count < maxCount; count++) {
            manualLottoContents.add(readLottoValue());
        }

        return manualLottoContents;
    }

    private static List<Integer> readLottoValue() {
        try {
            final String[] numbers = scanner.nextLine().split(LOTTO_NUMBER_DELIMITER);

            return Arrays.stream(numbers)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 `" + LOTTO_NUMBER_DELIMITER + "`로 구분하여 정수로 입력해야 합니다.", e);
        }
    }
}
