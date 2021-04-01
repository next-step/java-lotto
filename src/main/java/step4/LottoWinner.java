package step4;

import java.util.Objects;

public class LottoWinner {

    private Lotto lotto;
    private LottoNumber bonus;

    public LottoWinner(){}

    public LottoWinner(Lotto lotto, int bonus) {
        this.bonus = LottoNumber.of(bonus);
        if (lotto.contains(new LottoNumber(bonus))) {
            throw new IllegalArgumentException("보너스 번호는 중첩 될 수 없습니다");
        }
        this.lotto = lotto;
    }

    public Rank match(Lotto userlotto) {
        int count = userlotto.match(this.lotto);

        return Rank.rank(count, userlotto.contains(this.bonus));
    }

}
