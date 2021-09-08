package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateNumbers(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public List<LottoNumber> values() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public String toStringLottoNumber() {
        return lottoNumbers.toString();
    }

    private void validateNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }

        if (lottoNumbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
