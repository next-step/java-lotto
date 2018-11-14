package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<List<Integer>> lottoNumbers;
    private List<Integer> winningLotto;

    public Lotto() {
        this.lottoNumbers = new ArrayList<>();
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    public void putLottoNumber(List<Integer> integers) {
        this.lottoNumbers.add(integers);
    }

    public List<List<Integer>> lottoPapers() {
        return this.getLottoNumbers();
    }

    public void winningLottoNumber(List<Integer> integers) {
        this.winningLotto = integers;
    }

    public List<Integer> putWinningNumber() {
        return this.getWinningLotto();
    }
}
