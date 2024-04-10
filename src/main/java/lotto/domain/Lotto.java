package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final static int LOTTO_LENGTH = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public Set<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    public Lotto(String lottoNumbers) {
        Set<LottoNumber> newLottoNumbers = Arrays.stream(lottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        checkLottoCount(newLottoNumbers);
        this.lottoNumbers = newLottoNumbers;
    }

    private static void checkLottoCount(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("6개의 숫자가 필요합니다.");
        }
    }

    public int winningCount(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
