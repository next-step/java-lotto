package study.lotto;

import java.util.List;

public class WinningNumbers {
    private static LottoNumbers lottoNumbers = new LottoNumbers();

    List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers() {
        draw();
    }

    public void draw(){
        this.winningNumbers = lottoNumbers.autoCreatedNumbers();
    }

    public List<Integer> value() {
        return winningNumbers;
    }
}
