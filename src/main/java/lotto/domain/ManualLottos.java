package lotto.domain;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created By mand2 on 2020-12-01.
 */
public class ManualLottos {

    private final int round;

    public static final int ZERO = 0;
    public static final String MESSAGE_NON_NULL = "빈칸을 입력할 수 없습니다.";
    public static final String MESSAGE_NUMBER = "수동구매할 개수를 숫자로만 입력해주세요.";
    public static final String MESSAGE_NUMBER_POSITIVE = "음수로 입력할 수 없습니다.";


    private ManualLottos(int round) {
        this.round = round;
    }

    public static ManualLottos from(String manualRound) {
        int round = validate(manualRound);

        return new ManualLottos(round);
    }

    public int round() {
        return this.round;
    }

    private static int validate(String before) {
        checkNull(before);
        int number = getNumber(before);
        checkPositiveNumber(number);
        return number;
    }

    private static int getNumber(String before) {
        try {
            return Integer.valueOf(before);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_NUMBER);
        }
    }

    private static void checkNull(String before) {
        if (Objects.isNull(before) || before.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_NON_NULL);
        }
    }

    private static void checkPositiveNumber(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException(MESSAGE_NUMBER_POSITIVE);
        }
    }

}
