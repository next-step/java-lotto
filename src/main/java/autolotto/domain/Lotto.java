package autolotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        checkNumberCount();
        validateRange();
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        if (lottoNumbers == null) {
            return "[]";
        }
        return lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private void checkNumberCount() {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성됩니다. 입력 예)4, 6, 12, 24, 30, 39 ");
        }
    }

    private void validateRange() {
        if (lottoNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("로또 번호는 1~ 45까지의 숫자 입니다.");
        }
    }

    public int matchCount(Lotto lottoNumber, Lotto winNumber) {
        return (int) lottoNumber.lottoNumbers().stream().filter(winNumber.lottoNumbers()::contains).count();
    }
}
