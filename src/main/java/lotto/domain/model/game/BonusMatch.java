package lotto.domain.model.game;

import lotto.domain.model.lotto.LottoTicket;
import lotto.domain.model.lotto.WinningLottoTicket;

import java.util.Objects;

public final class BonusMatch {
    private static final BonusMatch MATCHES = new BonusMatch(true);
    private static final BonusMatch DOES_NOT_MATCH = new BonusMatch(false);

    private final boolean matches;

    private BonusMatch(final boolean matches) {
        this.matches = matches;
    }

    public static BonusMatch from(final boolean matches) {
        return matches ? MATCHES : DOES_NOT_MATCH;
    }

    public static BonusMatch of(final LottoTicket lottoTicket, final WinningLottoTicket winningLottoTicket) {
        return lottoTicket.contains(winningLottoTicket.getBonusNumber()) ? MATCHES : DOES_NOT_MATCH;
    }
    public boolean matches() {
        return matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusMatch that = (BonusMatch) o;
        return matches == that.matches;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches);
    }

    @Override
    public String toString() {
        return String.valueOf(matches);
    }
} 
