package step2.dto;

import step2.domain.InputLottoNumbers;

public class LottoConfirmationRequestDto {

    private final InputLottoNumbers inputLottoNumbers;

    private LottoConfirmationRequestDto(InputLottoNumbers inputLottoNumbers) {
        this.inputLottoNumbers = inputLottoNumbers;
    }

    private LottoConfirmationRequestDto(String inputLottoNumbers) {
        this(InputLottoNumbers.newInstance(inputLottoNumbers));
    }

    public static LottoConfirmationRequestDto newInstance(String inputLottoNumbers) {
        return new LottoConfirmationRequestDto(inputLottoNumbers);
    }

}
