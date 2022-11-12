package step3;

import java.util.Set;

public class LottoValidator {
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_SIZE = 6;

    public static void validateLottoSize(int size) {
        if (size != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복되지 않는 숫자 " + LOTTO_SIZE + "개를 입력해주세요.");
        }
    }

    public static void validateLottoRange(Set<Integer> lotto) {
        for (Integer number : lotto) {
            checkRange(number);
        }
    }

    private static void checkRange(Integer number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new IllegalArgumentException(LOTTO_START + " ~ " + LOTTO_END + " 사이의 수만 입력해주세요");
        }
    }
}
