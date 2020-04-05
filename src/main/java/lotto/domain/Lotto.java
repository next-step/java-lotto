package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateOfWinningNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(Integer... numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
               lottoNumbers.add(new LottoNumber(number));
        }
        validateOfWinningNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateOfWinningNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("6개의 로또 번호를 입력해 주세요.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int match(Lotto winningLotto) {
        List<LottoNumber> winning = winningLotto.getLottoNumbers();
        int match = 0;
        for (int i = 0; i < winning.size(); i++) {
            match += contains(winning.get(i));
        }
        return match;
    }

    private int contains(LottoNumber winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
