package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatusesResponseDto {

    private final List<LottoStatusResponseDto> lottoStatuses;

    public LottoStatusesResponseDto(Lottos lottos) {
        this.lottoStatuses = lottos.getLottos().stream()
                .map(LottoStatusResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<LottoStatusResponseDto> getLottoStatuses() {
        return lottoStatuses;
    }

    public static class LottoStatusResponseDto {

        private final List<Integer> lottoStatus;

        public LottoStatusResponseDto(List<LottoNumber> lottoNumbers) {
            this.lottoStatus = lottoNumbers.stream()
                    .mapToInt(LottoNumber::getLottoNumber)
                    .boxed()
                    .collect(Collectors.toList());
        }

        public List<Integer> getLottoStatus() {
            return lottoStatus;
        }
    }
}
