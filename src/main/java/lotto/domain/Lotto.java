package lotto.domain;

import lotto.domain.constant.Rank;

import java.util.Objects;

public class Lotto {
    private static final String EMPTY_LOTTO_NUMBERS = "로또 번호가 비어있습니다.";

    private final LottoNumbers lottoNumbers;
    private Rank rank;

    public Lotto(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;

    }

    private void validate(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException(EMPTY_LOTTO_NUMBERS);
        }

        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_NUMBERS);
        }
    }

    public void confirm(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        this.rank = Rank.create(this.lottoNumbers.matchCount(lottoNumbers), this.lottoNumbers.isContain(bonusNumber));
    }

    public boolean isSameRank(Rank rank) {
        return this.rank == rank;
    }

    public int getPrizeMoney() {
        return rank.getPrizeMoney();
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
