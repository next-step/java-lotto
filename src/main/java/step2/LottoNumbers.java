package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 45;
    private static final int NUMBER_COUNT = 5;
    private static final List<Integer> allNumbers;

    static {
        allNumbers = new ArrayList<>();
        for (int i = NUM_MIN; i <= NUM_MAX; i++) {
            allNumbers.add(i);
        }
    }

    private final List<Integer> numbers;

    public LottoNumbers() {
        Collections.shuffle(allNumbers);
        numbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT; i++) {
            numbers.add(allNumbers.get(i));
        }
    }

    //랜덤값 테스트를 위한 생성자
    protected LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(LottoNumbers.class)) {
            return false;
        }
        LottoNumbers other = (LottoNumbers) o;
        return isNumbersSame(other);
    }

    private boolean isNumbersSame(LottoNumbers other) {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (!numbers.get(i).equals(other.numbers.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
