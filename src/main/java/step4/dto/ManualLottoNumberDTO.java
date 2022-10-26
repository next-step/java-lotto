package step4.dto;

import java.util.Set;

public class ManualLottoNumberDTO {
    private Set<Integer> manualLottoNumbers;

    private ManualLottoNumberDTO(Set<Integer> manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public static ManualLottoNumberDTO from(Set<Integer> manualLottoNumbers) {
        return new ManualLottoNumberDTO(manualLottoNumbers);
    }

    public Set<Integer> getManualLottoNumbers() {
        return manualLottoNumbers;
    }
}
