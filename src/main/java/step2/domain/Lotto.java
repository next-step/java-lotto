package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Lotto {

    private final List<Integer> LottoNumbers;
    private Rank rank;

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
                .sorted().collect(toUnmodifiableList());
    }

    public List<Integer> toNumberList() {
        return this.LottoNumbers;
    }

    public Rank match(List<Integer> winnerNumber) {
        int countOfMatch = LottoNumbers.stream()
                .filter(winnerNumber::contains).map(e -> 1).reduce(0, Integer::sum);
        return Rank.valueOf(countOfMatch);
    }
}