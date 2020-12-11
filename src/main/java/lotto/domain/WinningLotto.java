package lotto.domain;

import java.util.Objects;

public class WinningLotto {

    private final LottoTicket winningTicket;

    private final LottoNumber bonus;

    private WinningLotto(final LottoTicket winningTicket, final LottoNumber bonus) {
        this.winningTicket = Objects.requireNonNull(winningTicket);
        this.bonus = Objects.requireNonNull(bonus);
    }

    public static WinningLotto of(final LottoTicket winnerTicket, final LottoNumber bonus) {
        if (winnerTicket.contains(bonus)) {
            throw new IllegalArgumentException(
                    String.format("보너스 번호는 로또 티켓 번호와 중복 될 수 없습니다. (보너스: %d)", bonus.getValue()));
        }
        return new WinningLotto(winnerTicket, bonus);
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return winningTicket.contains(lottoNumber);
    }

    public boolean isBonus(final LottoNumber bonus) {
        return this.bonus.equals(bonus);
    }
}
