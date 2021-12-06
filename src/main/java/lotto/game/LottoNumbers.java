package lotto.game;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public static LottoNumbers generate(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("로또는 %d자리 숫자만을 선택할 수 있습니다.", LOTTO_NUMBER_COUNT));
        }
        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("로또는 서로다른 %d자리 숫자만을 선택할 수 있습니다.", LOTTO_NUMBER_COUNT));
        }
    }

    public int matchCount(LottoNumbers lottoNumbers) {
        long count = lottoNumbers.lottoNumbers.stream()
                .map(this.lottoNumbers::contains)
                .filter(contain -> contain)
                .count();
        return Long.valueOf(count).intValue();
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
