package lottoGame.model.lotto;

import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> lottoNumber;

    public Lotto(List<LottoNumber> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int countMatch(WinningLotto winningLotto) {
        return Math.toIntExact(winningLotto.getLotto()
                .stream()
                .filter(this::existedMatchNumber)
                .count());
    }

    public List<LottoNumber> getLotto() {
        return lottoNumber;
    }

    private boolean existedMatchNumber(LottoNumber winningNum) {
        return lottoNumber.stream()
                .anyMatch(lottoNo -> lottoNo.isMatchOrNot(winningNum.getLottoNumber()));
    }

    public List<LottoNumber> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumber);
    }

    @Override
    public String toString() {
        return "" + lottoNumber + "";
    }

}
