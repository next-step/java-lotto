package step2.domain.checker;

import step2.domain.lotto.Lotto;
import step2.dto.LottoConfirmationRequestDto;

public final class LottoWinningChecker {

    private final Lotto lotto;

    private LottoWinningChecker(LottoConfirmationRequestDto confirmationRequestDto) {
        this(confirmationRequestDto.getLotto());
    }

    private LottoWinningChecker(Lotto lotto) {
        this.lotto = lotto;
    }

    public static final LottoWinningChecker newInstance(LottoConfirmationRequestDto confirmationRequestDto) {
        return new LottoWinningChecker(confirmationRequestDto);
    }

    public static final LottoWinningChecker newInstance(Lotto lotto) {
        return new LottoWinningChecker(lotto);
    }

}
