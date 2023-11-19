package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    static final int LOTTO_MAX_NUMBER = 45;
    static final int LOTTO_MIN_NUMBER = 1;

    private List<Integer> lottos;

    public Lotto() {
        this.lottos = IntStream.range(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lotto(List<Integer> numbers) {
        validation(numbers);
        this.lottos = numbers;
    }

    public List<Integer> getLotto() {
        return lottos;
    }

    private void validation(List<Integer> numbers) {

        for(int number : numbers){
            validationNumber(number);
        }
    }

    private static void validationNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 로또 번호 입니다.");
        }
    }
}
