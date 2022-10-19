package lotto;

import java.util.List;

public class SelectedLottoes {
    private final List<LottoNumber> selectedLottoes;

    public SelectedLottoes(List<LottoNumber> selectedLottoes) {
        this.selectedLottoes = selectedLottoes;
    }

    public List<LottoNumber> getSelectedLottoes() {
        return selectedLottoes;
    }

    public boolean isWinning(LottoNumber lottoNumber) {
        return selectedLottoes.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return selectedLottoes.toString();
    }
}
