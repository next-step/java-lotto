package step2.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public void drawLotto(UserLotto userLotto) {
        getLottoNumbers().stream().forEach(number -> userLotto.findHit(number, bonusNumber));
    }
}
