package lotto.domain;

import lotto.util.ShuffleUtil;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int SIZE = 6;
    public final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this(ShuffleUtil.shuffledLottoNumbers(LottoNumber.MIN, LottoNumber.MAX, SIZE));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (!isSameSize(lottoNumbers.size())) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private boolean isSameSize(int size) {
        return Lotto.SIZE == size;
    }

}
