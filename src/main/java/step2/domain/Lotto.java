package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lotto {

    private List<Integer> LottoNumbers;

    public Lotto() {
        List<Integer> numbers = createNumber();
        shuffle(numbers);
        this.LottoNumbers = pickNumber(numbers);
    }

    public Lotto(List<Integer> numbers) {
        this.LottoNumbers = numbers;
    }

    public List<Integer> createNumber() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(toList());
    }

    public void shuffle(List<Integer> lottoNumber) {
        Collections.shuffle(lottoNumber);
    }

    public List<Integer> pickNumber(List<Integer> lottoNumber) {
        return lottoNumber.stream()
                .limit(6)
                .collect(toList());
    }

    public List<Integer> toNumberList() {
        return this.LottoNumbers;
    }
}