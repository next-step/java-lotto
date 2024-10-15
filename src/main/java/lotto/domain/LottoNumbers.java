package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(Integer... input) {
        this(Arrays.stream(input).collect(Collectors.toList()));
    }

    public LottoNumbers(String[] input) {
        this(Arrays.stream(input).map(Integer::valueOf).collect(Collectors.toList()));
    }

    public LottoNumbers(List<Integer> input) {
        validatePolicy(input);
        this.lottoNumbers = input.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private void validatePolicy(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 로또 번호로 구성되어야 합니다.");
        }
    }

    public int countMatchingNumbers(LottoNumbers lottoNumbers) {
        int matchingCount = 0;
        for (LottoNumber number : lottoNumbers.lottoNumbers) {
            if (this.lottoNumbers.contains(number)) {
                matchingCount += 1;
            }
        }
        return matchingCount;
    }

    public List<LottoNumber> values() {
        return lottoNumbers;
    }
}
