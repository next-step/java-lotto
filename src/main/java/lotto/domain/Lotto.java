package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        checkNumbers(numbers);
        this.lottoNumbers = numbers
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void checkNumbers(List<Integer> numbers) {
        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("중복된 번호가 입력되었습니다.");
        }
        if (checkNumberOfCount(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }

    private static boolean isDuplicateNumber(List<Integer> winNumbers) {
        return winNumbers.size() != new HashSet<>(winNumbers).size();
    }

    private static boolean checkNumberOfCount(List<Integer> winNumbers) {
        return winNumbers.size() != 6;
    }
    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
