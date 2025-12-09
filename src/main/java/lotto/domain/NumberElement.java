package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class NumberElement {

    private static final Map<Integer, NumberElement> numberElementMap = new HashMap<>();
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    static {
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            numberElementMap.put(i, new NumberElement(i));
        }
    }

    private final int value;

    private NumberElement() {
        this(0);
    }

    private NumberElement(int value) {
        validationRange(value);
        this.value = value;
    }

    public static NumberElement create(int value) {
        validationRange(value);
        return numberElementMap.get(value);
    }

    private static void validationRange(int value) {
        if (isRange(value)) {
            throw new IllegalArgumentException("1에서 45 사이의 숫자를 입력해주세요.");
        }
    }

    private static boolean isRange(int value) {
        return START_NUMBER > value || value > END_NUMBER;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
