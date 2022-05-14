package lotto.domain;

import lotto.domain.constant.Rank;

public class Lotto {
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private final LottoNumbers lottoNumbers;
    private Rank rank;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void confirm(LottoNumbers lottoNumbers) {
        this.rank = Rank.create(this.lottoNumbers.matchCount(lottoNumbers));
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
