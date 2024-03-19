package step2;

import java.util.List;

public class WinnerNumbers {

    private final LottoNumbers winNumbers;

    public WinnerNumbers(String numbers) {
        winNumbers = new LottoNumbers(numbers);
    }

    public List<Integer> getWinNumbers() {
        return winNumbers.getLottoNumbers();
    }
}
