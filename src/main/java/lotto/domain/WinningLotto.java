package lotto.domain;

import java.util.Objects;
import java.util.Optional;

public class WinningLotto {

    public static final String ERR_DUPLICATE_BOUNS = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private final Lotto winning;
    private final LottoNumber bonus;

    public WinningLotto(Lotto winning, LottoNumber bonus) {
        if (isDuplicate(winning, bonus)) {
            throw new IllegalArgumentException(ERR_DUPLICATE_BOUNS);
        }
        this.winning = winning;
        this.bonus = bonus;
    }

    private boolean isDuplicate(Lotto winning, LottoNumber bonus) {
        Optional<LottoNumber> dupLottoNumber = winning.getLottoNumbers().stream()
                .filter(lottoNumber -> lottoNumber.equals(bonus))
                .findAny();

        if (dupLottoNumber.isPresent()) return true;
        return false;
    }

    public Lotto getWinningLotto() {
        return winning;
    }

    public LottoNumber getBonusNumber() {
        return bonus;
    }
}
