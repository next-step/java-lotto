package step02.dto;

import step02.domain.EarningRate;

import static step02.domain.EarningRate.TIE_RATIO;

public class EarningRateDto {

    private final float value;

    public EarningRateDto(float value) {
        this.value = value;
    }

    public static EarningRateDto from(EarningRate earningRate) {
        return new EarningRateDto(earningRate.getValue());
    }

    public float getValue() {
        return value;
    }

    public boolean isEarn() {
        return value >= TIE_RATIO;
    }
}
