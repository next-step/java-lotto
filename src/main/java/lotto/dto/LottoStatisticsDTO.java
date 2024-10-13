package lotto.dto;

import java.util.Objects;

public class LottoStatisticsDTO {
    private final double percentageRateOfReturn;
    private final LottoRewardInfosDTO matchInfosDTO;

    private LottoStatisticsDTO(double percentageRateOfReturn, LottoRewardInfosDTO matchInfosDTO) {
        this.percentageRateOfReturn = percentageRateOfReturn;
        this.matchInfosDTO = matchInfosDTO;
    }

    public static LottoStatisticsDTO valueOf(double percentageRateOfReturn, LottoRewardInfosDTO matchCountsDTO) {
        return new LottoStatisticsDTO(percentageRateOfReturn, matchCountsDTO);
    }

    public double getPercentageRateOfReturn() {
        return percentageRateOfReturn;
    }

    public LottoRewardInfosDTO getMatchInfosDTO() {
        return matchInfosDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStatisticsDTO that = (LottoStatisticsDTO) o;
        return getPercentageRateOfReturn() == that.getPercentageRateOfReturn() && Objects.equals(getMatchInfosDTO(), that.getMatchInfosDTO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPercentageRateOfReturn(), getMatchInfosDTO());
    }
}
