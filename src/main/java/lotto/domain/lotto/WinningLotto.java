package lotto.domain.lotto;

import static util.Preconditions.checkArgument;

public class WinningLotto {
    public static final String WINNING_LOTTO_NO_BONUS_NO_MUST_BE_NOT_DUPLICATED = "winning lotto no and bonus number must be not duplicated";

    private final LottoTicket lottoTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        checkArgument(isNotDuplicate(lottoTicket, bonusNumber), WINNING_LOTTO_NO_BONUS_NO_MUST_BE_NOT_DUPLICATED);
        return new WinningLotto(lottoTicket, bonusNumber);
    }

    private static boolean isNotDuplicate(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        return !lottoTicket.isContain(bonusNumber);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
