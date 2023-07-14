package lotto.dto;

import java.util.List;

public class ManualRequestDto {

    private final List<List<Integer>> manualLottos;

    public ManualRequestDto(List<List<Integer>> manualLottos) {
        this.manualLottos = manualLottos;
    }

    public List<List<Integer>> getManualLottos() {
        return manualLottos;
    }
}
