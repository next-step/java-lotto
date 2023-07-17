package lotto.view;

import lotto.domain.*;

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

    public static Lotto readWinningLottoValue() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return readLotto();
    }

    public static LottoNumber readLottoNumberValue() {
        System.out.println("보너스 볼을 입력해 주세요.");

        try {
            final int number = Integer.parseInt(scanner.nextLine());
            System.out.println();

            return new LottoNumber(number);
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

    public static Lottos readManualLottos(final long maxCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> manualLottosContent = new ArrayList<>();
        for (int count = 0; count < maxCount; count++) {
            manualLottosContent.add(readLotto());
        }

        return new Lottos(manualLottosContent);
    }

    private static Lotto readLotto() {
        try {
            final String[] numbers = scanner.nextLine().split(LOTTO_NUMBER_DELIMITER);

            return new Lotto(Arrays.stream(numbers)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 `" + LOTTO_NUMBER_DELIMITER + "`로 구분하여 정수로 입력해야 합니다.", e);
        }
    }
}
