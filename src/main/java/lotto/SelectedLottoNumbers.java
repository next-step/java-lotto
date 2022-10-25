package lotto;

import java.util.List;

public class SelectedLottoNumbers {
    private final List<LottoNumber> selectedLottoNumbers;

    public SelectedLottoNumbers(List<LottoNumber> selectedLottoNumbers) {
        this.selectedLottoNumbers = selectedLottoNumbers;
    }

    public List<LottoNumber> getSelectedLottoNumbers() {
        return selectedLottoNumbers;
    }

    public boolean isWinning(LottoNumber lottoNumber) {
        return selectedLottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return selectedLottoNumbers.toString();
    }
}
