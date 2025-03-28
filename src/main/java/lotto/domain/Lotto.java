package lotto.domain;

import java.util.List;


public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        lottoNumbers.forEach(this::validateNumber);
        checkDuplicate(lottoNumbers);
        checkSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumber(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
        }
    }

    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void checkDuplicate(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers;
    }

    public int matchCount(Lotto lastWeekLotto) {
        return (int) this.lottoNumbers().stream()
            .filter(lastWeekLotto.lottoNumbers()::contains)
            .count();
    }


}
