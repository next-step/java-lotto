package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        List<LottoNumber> lottoNumberList = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        validateDuplicateNumbers(lottoNumberList);
        this.lottoNumbers = lottoNumberList;
    }

    public boolean contains(LottoNumber number) {
        return this.lottoNumbers.contains(number);
    }

    public int matchCount(WinningNumber winningNumber) {
        return (int) lottoNumbers.stream()
                .filter(winningNumber::containsNumbers)
                .count();
    }

    public boolean matchBonusNumber(WinningNumber winningNumber) {
        return lottoNumbers.stream()
                .anyMatch(winningNumber::matchBonusNumber);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());
    }

    private void validateDuplicateNumbers(List<LottoNumber> numbers) {
        List<LottoNumber> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또번호는 중복될 수 없습니다.");
        }
    }
}
