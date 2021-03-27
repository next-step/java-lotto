package step2.domain.lotto;

import step2.dto.LottoConfirmationRequestDto;

public class LottoWinningChecker {

    private final InputLottoNumbers inputLottoNumbers;

    private LottoWinningChecker(LottoConfirmationRequestDto confirmationRequestDto) {
        this(confirmationRequestDto.getInputLottoNumbers());
    }

    private LottoWinningChecker(InputLottoNumbers inputLottoNumbers) {
        this.inputLottoNumbers = inputLottoNumbers;
    }

    public static final LottoWinningChecker newInstance(LottoConfirmationRequestDto confirmationRequestDto) {
        return new LottoWinningChecker(confirmationRequestDto);
    }

    public static final LottoWinningChecker newInstance(InputLottoNumbers inputLottoNumbers) {
        return new LottoWinningChecker(inputLottoNumbers);
    }

}
