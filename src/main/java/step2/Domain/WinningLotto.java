package step2.Domain;

import java.util.List;

public class WinningLotto {

    private LottoNumber bonusBall;
    private Lotto lotto;

    public WinningLotto(Lotto lotto, LottoNumber bonusBall) {
        this.lotto = lotto;
        if (bonusBallDuplicateCheck(bonusBall)) {
            throw new IllegalArgumentException("지난 주 당첨번호와 보너스 볼이 중복됩니다.");
        }
        this.bonusBall = bonusBall;
    }

    private boolean bonusBallDuplicateCheck(LottoNumber bonusBall) {
        return this.getLottoNumberList().stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }

    public List<LottoNumber> getLottoNumberList() {
        return lotto.getLottoNumberList();
    }

    public LottoNumber bonusBall() {
        return bonusBall;
    }
}
