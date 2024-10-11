package lotto.dto;

import java.math.BigDecimal;
import java.util.List;

public class ResultDto {
    private final List<RankDto> rankDtos;
    private final BigDecimal rate;

    public ResultDto(List<RankDto> rankDtos, BigDecimal rate) {
        this.rankDtos = rankDtos;
        this.rate = rate;
    }

    public List<RankDto> getRankDtos() {
        return rankDtos;
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "rankDtos=" + rankDtos +
                ", rate=" + rate +
                '}';
    }
}
