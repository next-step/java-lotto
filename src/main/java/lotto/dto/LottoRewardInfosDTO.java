package lotto.dto;

import java.util.List;
import java.util.Objects;

public class LottoRewardInfosDTO {
    private final List<LottoRewardInfoDTO> rewardInfoDTOs;

    private LottoRewardInfosDTO(List<LottoRewardInfoDTO> rewardInfoDTOs) {
        this.rewardInfoDTOs = rewardInfoDTOs;
    }

    public static LottoRewardInfosDTO valueOf(List<LottoRewardInfoDTO> rewardInfoDTOs) {
        return new LottoRewardInfosDTO(rewardInfoDTOs);
    }

    public List<LottoRewardInfoDTO> getRewardInfoDTOs() {
        return rewardInfoDTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoRewardInfosDTO that = (LottoRewardInfosDTO) o;
        return Objects.equals(getRewardInfoDTOs(), that.getRewardInfoDTOs());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRewardInfoDTOs());
    }
}
