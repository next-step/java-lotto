package step2.domain.Lotto;

import step2.dto.LottoConfirmationRequestDto;

public class LottoWinningChecker {

    private LottoWinningChecker(LottoConfirmationRequestDto confirmationRequestDto) {

    }

    public static LottoWinningChecker getInstance(LottoConfirmationRequestDto confirmationRequestDto) {
        return new LottoWinningChecker(confirmationRequestDto);
    }
}
