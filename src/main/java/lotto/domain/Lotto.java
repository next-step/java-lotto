package lotto.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    private static final String NUMBER_IS_INVALID = "유효하지 않은 번호 입니다.";
    private static final String LOTTO_IS_INVALID = "유효하지 않은 로또입니다.";

    private Set<Integer> lotto;

    public Lotto(Set<Integer> numbers) {
        validation(numbers);
        this.lotto = numbers;
    }

    public Set<Integer> getLotto() {
        return lotto;
    }

    private void validation(Set<Integer> numbers) {
        lottoNumberValidation(numbers);
        lottoSizeValidation(numbers);
    }

    private static void lottoNumberValidation(Set<Integer> numbers) {
        Iterator<Integer> iter = numbers.iterator();
        while (iter.hasNext())
            lottoMinMaxValidation(iter);
    }

    private static void lottoMinMaxValidation(Iterator<Integer> iter) {
        if(iter.next() < LOTTO_MIN_NUMBER || iter.next() > LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException(NUMBER_IS_INVALID);
        }
    }

    private static void lottoSizeValidation(Set<Integer> numbers) {
        if(numbers.size() != 6){
            throw new IllegalArgumentException(LOTTO_IS_INVALID);
        }
    }
}
