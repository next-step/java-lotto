package lotto.dto;

import lotto.domain.LottoNumbers;
import lotto.utils.LottoConverter;

import java.util.List;

public class LottoRequestDto {

    private int autoAmount;
    private List<LottoNumbers> manualLottoNumbers;

    public LottoRequestDto(int autoAmount, List<String> manualLottoNumbers) {
        this.autoAmount = autoAmount;
        this.manualLottoNumbers = LottoConverter.convertToLottoNumbers(manualLottoNumbers);
    }

    public int getAutoAmount() {
        return autoAmount;
    }

    public List<LottoNumbers> getManualLottoNumbers() {
        return manualLottoNumbers;
    }
}
