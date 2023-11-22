package autolotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNo> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream().map(LottoNo::new).collect(Collectors.toList());
        checkNumberCount();
        checkDuplicateNumber();
    }

    public List<LottoNo> lottoNumbers() {
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

    public int matchCount(Lotto lottoNumber, Lotto winNumber) {
        return (int) lottoNumber.lottoNumbers().stream().filter(winNumber.lottoNumbers()::contains).count();
    }

    private void checkDuplicateNumber() {
        Set<LottoNo> uniqueNumber = lottoNumbers.stream().collect(Collectors.toSet());
        if (lottoNumbers.size() != uniqueNumber.size()) {
            throw new IllegalArgumentException("로또번호 중 중복된 숫자가 존재합니다. 다시 입력해 주세요.");
        }
    }
}
