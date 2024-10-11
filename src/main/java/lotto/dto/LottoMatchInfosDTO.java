package lotto.dto;

import java.util.List;
import java.util.Objects;

public class LottoMatchInfosDTO {
    private final List<LottoMatchInfoDTO> matchInfoDTOs;

    private LottoMatchInfosDTO(List<LottoMatchInfoDTO> matchInfoDTOs) {
        this.matchInfoDTOs = matchInfoDTOs;
    }

    public static LottoMatchInfosDTO valueOf(List<LottoMatchInfoDTO> matchCountDTOs) {
        return new LottoMatchInfosDTO(matchCountDTOs);
    }

    public List<LottoMatchInfoDTO> getMatchInfoDTOs() {
        return matchInfoDTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatchInfosDTO that = (LottoMatchInfosDTO) o;
        return Objects.equals(getMatchInfoDTOs(), that.getMatchInfoDTOs());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getMatchInfoDTOs());
    }
}
