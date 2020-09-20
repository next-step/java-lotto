package step2.domain;

import java.util.Iterator;

public class WinningLotto {

    private final Lotto winningLottoNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLottoNumbers, LottoNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(String nums, String bonusNumber) {
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(Integer.parseInt(bonusNumber));
        Lotto winningLotto = Lotto.create(nums);

        if (winningLotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복이 되어선 안됩니다.");
        }

        return new WinningLotto(winningLotto, bonusLottoNumber);
    }

    public Rank match(Lotto lotto) {
        return Rank.getRank(matchNumber(lotto), lotto.contains(bonusNumber));
    }

    private int matchNumber(Lotto lotto) {
        int resultMatchNumberCount = 0;

        for (LottoNumber lottoNumber : lotto) {
            if (winningLottoNumbers.contains(lottoNumber)) {
                resultMatchNumberCount += 1;
            }
        }

        return resultMatchNumberCount;
    }
}
