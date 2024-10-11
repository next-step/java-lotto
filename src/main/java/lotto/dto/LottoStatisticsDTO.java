package lotto.dto;

import java.util.Objects;

public class LottoStatisticsDTO {
    private final int percentageRateOfReturn;
    private final LottoMatchInfosDTO matchInfosDTO;

    private LottoStatisticsDTO(int percentageRateOfReturn, LottoMatchInfosDTO matchInfosDTO) {
        this.percentageRateOfReturn = percentageRateOfReturn;
        this.matchInfosDTO = matchInfosDTO;
    }

    public static LottoStatisticsDTO valueOf(int percentageRateOfReturn, LottoMatchInfosDTO matchCountsDTO) {
        return new LottoStatisticsDTO(percentageRateOfReturn, matchCountsDTO);
    }

    public int getPercentageRateOfReturn() {
        return percentageRateOfReturn;
    }

    public LottoMatchInfosDTO getMatchInfosDTO() {
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
