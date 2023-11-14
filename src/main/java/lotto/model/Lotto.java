package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoSizeCheck(numbers);
        Collections.sort(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }
    public List<Integer> lottoNumbers(){
        return this.numbers;
    }

    private void lottoSizeCheck(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또번호는 정확히" + LOTTO_NUMBER_SIZE + "개 여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
