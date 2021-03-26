package step2.dto;

import step2.domain.InputMoney;

public final class LottoCreationRequestDto {

    private final InputMoney inputMoney;

    private LottoCreationRequestDto(int inputMoney) {
        this(InputMoney.valueOf(inputMoney));
    }

    private LottoCreationRequestDto(InputMoney inputMoney) {
        this.inputMoney = inputMoney;
    }

    public static final LottoCreationRequestDto newInstance(int inputMoney) {
        return new LottoCreationRequestDto(inputMoney);
    }

    public static final LottoCreationRequestDto newInstance(InputMoney inputMoney) {
        return new LottoCreationRequestDto(inputMoney);
    }

}
