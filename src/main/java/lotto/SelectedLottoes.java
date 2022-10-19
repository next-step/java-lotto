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

    @Override
    public String toString() {
        return selectedLottoes.toString();
    }
}
