package lotto.dto;

import java.util.List;

public class LottoDto {

    private final List<Integer> manualLottoNumbers;

    public LottoDto(List<Integer> manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public List<Integer> getManualLottoNumbers() {
        return manualLottoNumbers;
    }
}
