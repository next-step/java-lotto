package study.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final String ERROR_MESSAGE ="정확한 당첨 번호를 입력해 주세요";
    private static final String NUMBER_DELIMITER = ", |,";
    private LottoNumbers lottoNumbers = new LottoNumbers();

    List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers() {
        draw();
    }

    public WinningNumbers(String inputWinningNumbers) throws IllegalAccessException {
        Set<Integer> winningNumbersSet = new HashSet<>();
        for (String stringNumber : inputWinningNumbers.split(NUMBER_DELIMITER)) {
            int number = Integer.parseInt(stringNumber);
            checkLottoNumber(number);
            winningNumbersSet.add(number);
        }
        checkSize(winningNumbersSet);
        this.winningNumbers = new ArrayList<>(winningNumbersSet);
    }

    private void checkSize(Set<Integer> winningNumbers) throws IllegalAccessException {
        if (winningNumbers.size() != 6) {
            throw new IllegalAccessException(ERROR_MESSAGE);
        }
    }

    private void checkLottoNumber(int winningNumber) throws IllegalAccessException {
        if (!lottoNumbers.values().contains(winningNumber)){
            throw new IllegalAccessException(ERROR_MESSAGE);
        }
    }

    public void draw(){
        this.winningNumbers = lottoNumbers.autoCreatedNumbers();
    }

    public List<Integer> value() {
        return winningNumbers;
    }
}
