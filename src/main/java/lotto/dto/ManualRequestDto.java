package lotto.dto;

import java.util.List;

public class ManualRequestDto {

    private final int count;
    private final List<List<Integer>> manualLottos;

    public ManualRequestDto(int count, List<List<Integer>> manualLottos) {
        this.count = count;
        this.manualLottos = manualLottos;
    }

    public int getCount() {
        return count;
    }

    public List<List<Integer>> getManualLottos() {
        return manualLottos;
    }
}
