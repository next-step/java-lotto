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
    private static final int WIN_NUMBER_LENGTH = 6;

    public Lotto() {
        List<Integer> numbers = createNumber();
        shuffle(numbers);
        List<LottoNumber> lottoNumbers = pickNumber(numbers);
        valid(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(List<LottoNumber> numbers) {
        valid(numbers);
        this.lottoNumbers = numbers;
    }

    private void valid(List<LottoNumber> numbers) {
        if (numbers.size() != WIN_NUMBER_LENGTH) {
            throw new IllegalArgumentException("당첨번호가 6개가 아닙니다.");
        }
        boolean duplicated = numbers.stream()
                .distinct().count() != numbers.size();
        if (duplicated) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
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

    public int match(Lotto winnerNumber) {
        return lottoNumbers.stream()
                .filter(winnerNumber.lottoNumbers::contains)
                .map(e -> 1).reduce(0, Integer::sum);
    }

    public boolean matchBonus(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}