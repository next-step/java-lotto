package lotto.dto;

import java.util.List;

public class LottoStatusResponseDto {

    private final List<List<Integer>> lottoStatus;

    public LottoStatusResponseDto(List<List<Integer>> lottoStatus) {
        this.lottoStatus = lottoStatus;
    }

    public List<List<Integer>> getLottoStatus() {
        return lottoStatus;
    }
}
