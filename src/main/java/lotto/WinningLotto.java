package lotto;

import java.util.List;

public class WinningLotto extends Lotto{
    protected final LottoNumber bonusBall;

    public WinningLotto(final List<LottoNumber> numbers, final LottoNumber bonusBall) {
        super(numbers);
        if(hasDuplicate(bonusBall)) {
            throw new IllegalArgumentException("로또번호는 중복될 수 없습니다.");
        }
        this.bonusBall = bonusBall;
    }

    private boolean hasDuplicate(LottoNumber bonusBall) {
        return numbers.stream().anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }
}
