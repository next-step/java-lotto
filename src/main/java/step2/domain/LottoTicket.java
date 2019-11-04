package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    public static final int CORRECT_SIZE = 6;
    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers.size());
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(int size) {
        if (size != CORRECT_SIZE) {
            throw new IllegalArgumentException(size + "는 올바르지 않은 갯수입니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
