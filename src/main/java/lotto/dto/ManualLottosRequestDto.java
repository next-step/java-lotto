package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottosRequestDto {

    private final long manualCount;
    private final List<ManualLottoRequestDto> manualLottos;

    public ManualLottosRequestDto(long manualCount, List<List<Integer>> manualLottos) {
        this.manualCount = manualCount;
        this.manualLottos = manualLottos.stream()
                .map(ManualLottoRequestDto::new)
                .collect(Collectors.toList());
    }

    public long getManualCount() {
        return manualCount;
    }

    public List<ManualLottoRequestDto> getManualLottos() {
        return manualLottos;
    }

    public static class ManualLottoRequestDto {
        private final List<Integer> manualLotto;

        public ManualLottoRequestDto(List<Integer> manualLotto) {
            this.manualLotto = manualLotto;
        }

        public List<Integer> getManualLotto() {
            return manualLotto;
        }
    }
}
