package lotto.domain;

public class WinningLotto {
    private final LottoNumber bonusNumber;
    private final LottoNumbers winningNumbers;

    public static WinningLotto of(LottoNumber bonusNumber, LottoNumbers winningNumbers) {
        return new WinningLotto(bonusNumber, winningNumbers);
    }

    public static WinningLotto of(int bonusNumber, int... winningNumbers) {
        return new WinningLotto(LottoNumber.of(bonusNumber), LottoNumbers.of(winningNumbers));
    }

    private WinningLotto(LottoNumber bonusNumber, LottoNumbers winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String
                    .format("보너스 숫자(%d)는 중복될 수 없습니다.", bonusNumber.getNumber()));
        }
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public WiningResult match(LottoNumbers lottoNumbers) {
        return WiningResult.of(lottoNumbers.match(winningNumbers), lottoNumbers.contains(bonusNumber));
    }
}
