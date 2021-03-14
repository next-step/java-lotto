package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static step2.domain.LottoNumber.MAX_NUMBER;
import static step2.domain.LottoNumber.MIN_NUMBER;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        List<Integer> numbers = createNumber();
        shuffle(numbers);
        this.lottoNumbers = pickNumber(numbers);
    }

    public Lotto(List<LottoNumber> numbers) {
        this.lottoNumbers = numbers;
    }

    public List<Integer> createNumber() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(toList());
    }

    public void shuffle(List<Integer> lottoNumber) {
        Collections.shuffle(lottoNumber);
    }

    public List<LottoNumber> pickNumber(List<Integer> lottoNumber) {
        return lottoNumber.stream()
                .limit(6)
                .sorted()
                .map(LottoNumber::new)
                .collect(toUnmodifiableList());
    }

    public List<LottoNumber> toNumberList() {
        return this.lottoNumbers;
    }

    public Rank match(List<LottoNumber> winnerNumber) {
        int countOfMatch = lottoNumbers.stream()
                .filter(winnerNumber::contains)
                .map(e -> 1).reduce(0, Integer::sum);
        return Rank.valueOf(countOfMatch);
    }
}