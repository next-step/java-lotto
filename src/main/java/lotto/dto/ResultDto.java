package lotto.dto;

import java.math.BigDecimal;
import java.util.List;

public class ResultDto {

    private final BigDecimal rate;
    private final List<PrizeMoneyDto> prizeMoneyDto;

    public ResultDto(BigDecimal rate, List<PrizeMoneyDto> prizeMoneyDto) {
        this.rate = rate;
        this.prizeMoneyDto = prizeMoneyDto;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public List<PrizeMoneyDto> getPrizeMoneyDto() {
        return prizeMoneyDto;
    }
}
