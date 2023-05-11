package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<LottoNumber> winNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> winNumbers, Integer bonusNumber) {
        checkNumbers(winNumbers, bonusNumber);
        this.winNumbers = toLottoNumbers(winNumbers);
        this.bonusNumber = toLottoNumber(bonusNumber);
    }


    private LottoNumber toLottoNumber(Integer bonusNumber) {
        return new LottoNumber(bonusNumber);
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> winNumbers) {
        return winNumbers.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    public LottoMatcher match(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.lottoNumbers();
        long matchedSize = lottoNumbers.stream()
                .filter(winNumbers::contains)
                .count();
        boolean matchBonus = lottoNumbers.contains(bonusNumber);
        return LottoMatcher.of((int) matchedSize, matchBonus);
    }


    private void checkNumbers(List<Integer> winNumbers, Integer bonusNumber) {
        if (isDuplicateNumber(winNumbers)) {
            throw new IllegalArgumentException("중복된 번호가 입력되었습니다.");
        }
        if (existNumber(winNumbers, bonusNumber)) {
            throw new IllegalArgumentException("이미 존재하는 번호입니다.");
        }
        if (checkNumberOfCount(winNumbers)) {
            throw new IllegalArgumentException("로또 당첨번호는 6개 입니다.");
        }
    }

    private static boolean checkNumberOfCount(List<Integer> winNumbers) {
        return winNumbers.size() != 6;
    }

    private static boolean existNumber(List<Integer> winNumbers, Integer bonusNumber) {
        return winNumbers.contains(bonusNumber);
    }

    private static boolean isDuplicateNumber(List<Integer> winNumbers) {
        return winNumbers.size() != new HashSet<>(winNumbers).size();
    }
}
