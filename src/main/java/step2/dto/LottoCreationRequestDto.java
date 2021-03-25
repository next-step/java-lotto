package step2.dto;

import step2.domain.InputMoney;

public class LottoCreationRequestDto {

    private final InputMoney inputMoney;

    private LottoCreationRequestDto(int inputValue) {
        this(InputMoney.valueOf(inputValue));
    }

    private LottoCreationRequestDto(InputMoney inputValue) {
        this.inputMoney = inputValue;
    }

    public static final LottoCreationRequestDto newInstance(int inputValue) {
        return new LottoCreationRequestDto(inputValue);
    }

}
