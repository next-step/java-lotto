package step2.view.dto;

import step2.domain.LottoNumber;

public class LottoNumberDto {

    private final int value;

    public LottoNumberDto(LottoNumber lottoNumber) {
        this.value = lottoNumber.getValue();
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
