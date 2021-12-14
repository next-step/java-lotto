package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Objects;

public class RetrieveStatisticsRequest {
    private final Lottos lottos;
    private final List<Integer> winningLottoNumbers;
    private final int bonusLottoNumber;

    private RetrieveStatisticsRequest(Lottos lottos, List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        validate(lottos, winningLottoNumbers, bonusLottoNumber);
        this.lottos = lottos;
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static RetrieveStatisticsRequest of(Lottos lottos, List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        return new RetrieveStatisticsRequest(lottos, winningLottoNumbers, bonusLottoNumber);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Lotto winningLotto() {
        return new Lotto(new LottoNumbers(winningLottoNumbers));
    }

    public LottoNumber bonusLottoNumber() {
        return new LottoNumber(bonusLottoNumber);
    }

    private void validate(Lottos lottos, List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        validateLottos(lottos);
        validateWinningLottoNumbers(winningLottoNumbers);
        validateBonusLottoNumber(bonusLottoNumber);
    }

    private void validateLottos(Lottos lottos) {
        if (Objects.isNull(lottos)) {
            throw new IllegalArgumentException("lottos가 null입니다.");
        }
    }

    private void validateWinningLottoNumbers(List<Integer> winningLottoNumbers) {
        if (Objects.isNull(winningLottoNumbers)) {
            throw new IllegalArgumentException("winningLottoNumbers가 null입니다.");
        }
        if (winningLottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("winningLottoNumbers의 사이즈가 0입니다.");
        }
    }

    private void validateBonusLottoNumber(int bonusLottoNumber) {
        if (bonusLottoNumber < LottoNumber.MIN_NUMBER || bonusLottoNumber > LottoNumber.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("보너스 번호는 %d<=x<=%d값이 전달되어야합니다.", LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            );
        }
    }
}
