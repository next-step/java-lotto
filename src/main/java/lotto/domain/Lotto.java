package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumber lottoNumber;

    public Lotto() {
        this(LottoNumberProvider.createLottoNumber());
    }

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public LottoRank getRank(LottoNumber winningLottoNumber) {
        return LottoRank.find(matchNumberCount(winningLottoNumber), matchBonusNumber(winningLottoNumber));
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    private long matchNumberCount(LottoNumber winningLottoNumber) {
        return winningLottoNumber.getNumbers()
                .stream()
                .filter(lottoNumber.getNumbers()::contains)
                .count();
    }

    private boolean matchBonusNumber(LottoNumber winningLottoNumber) {
        return lottoNumber.getBonusNumber() == winningLottoNumber.getBonusNumber();
    }
}
