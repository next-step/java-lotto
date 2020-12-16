package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this(new LottoNumbers(lottoNumbers));
    }

    public Lotto(LottoNumbers lottoNumbers) {
        if(lottoNumbers.getLottoNumbers().size() != LottoNumbers.DEFAULT_PICK_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호가 6개가 아닙니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.getLottoNumbers().toString();
    }
}
