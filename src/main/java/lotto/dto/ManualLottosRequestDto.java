package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottosRequestDto {

    private final List<ManualLottoRequestDto> manualLottos;

    public ManualLottosRequestDto(List<List<Integer>> manualLottos) {
        this.manualLottos = manualLottos.stream()
                .map(ManualLottoRequestDto::new)
                .collect(Collectors.toList());
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
