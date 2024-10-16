package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(Integer... input) {
        this(Arrays.stream(input).collect(Collectors.toList()));
    }

    public Lotto(String[] input) {
        this(Arrays.stream(input).map(Integer::valueOf).collect(Collectors.toList()));
    }

    public Lotto(List<Integer> input) {
        validatePolicy(input);
        this.lottoNumbers = input.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private void validatePolicy(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 로또 번호로 구성되어야 합니다.");
        }
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public List<LottoNumber> values() {
        return lottoNumbers;
    }
}
