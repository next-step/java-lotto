package lotto.dto.response;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.LottosCount;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatusesResponseDto {

    private final long autoLottosCount;
    private final long manualLottosCount;
    private final List<LottoStatusResponseDto> lottoStatuses;

    public LottoStatusesResponseDto(Lottos lottos, LottosCount manualLottosCount) {
        this.autoLottosCount = lottos.size() - manualLottosCount.getLottosCount();
        this.manualLottosCount = manualLottosCount.getLottosCount();
        this.lottoStatuses = lottos.getLottos().stream()
                .map(LottoStatusResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<LottoStatusResponseDto> getLottoStatuses() {
        return lottoStatuses;
    }

    public long getAutoLottosCount() {
        return autoLottosCount;
    }

    public long getManualLottosCount() {
        return manualLottosCount;
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
