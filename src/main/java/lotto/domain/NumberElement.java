package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class NumberElement {

    private static final Map<Integer, NumberElement> numberElementMap = new HashMap<>();

    static {
        for (int i = 1; i <= 45; i++) {
            numberElementMap.put(i, new NumberElement(i));
        }
    }

    private final int value;

    public NumberElement() {
        this(0);
    }

    public NumberElement(int value) {
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
        return 1 > value || value > 45;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
