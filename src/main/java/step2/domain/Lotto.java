package step2.domain;

import step2.util.StringParser;

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
        boolean duplicated = numbers.stream()
                .distinct().count() != numbers.size();
        if (duplicated) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
        this.lottoNumbers = numbers;
    }

    public Lotto(String lottoNumber) {
        this(StringParser.toLottoNumberList(lottoNumber));
    }

    public List<Integer> createNumber() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(toList());
    }

    public void shuffle(List<Integer> lottoNumber) {
        Collections.shuffle(lottoNumber);
    }

    private List<LottoNumber> pickNumber(List<Integer> lottoNumber) {
        return lottoNumber.stream()
                .limit(6)
                .sorted()
                .map(LottoNumber::of)
                .collect(toUnmodifiableList());
    }

    public List<LottoNumber> toNumberList() {
        return this.lottoNumbers;
    }

    public int match(List<LottoNumber> winnerNumber) {
        return lottoNumbers.stream()
                .filter(winnerNumber::contains)
                .map(e -> 1).reduce(0, Integer::sum);
    }

    public boolean matchBonus(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}