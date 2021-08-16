package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final int numOfWinningLottoNumber = 6;
    private static final String winningLottoNumberErrorMessage = "당첨 번호는 6개로 구성되어야 하며, ', ' 을 이용하여 구분하고 있습니다.";

    private List<Integer> numbers;

    public WinningLotto(String stringNumbers) {
        this.numbers = checkValidInput(stringNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> checkValidInput(String s) {
        String[] winningLottoNumberStringList = s.split(", ");
        if (winningLottoNumberStringList.length != numOfWinningLottoNumber) {
            throw new IllegalArgumentException(winningLottoNumberErrorMessage);
        }
        return makeIntList(winningLottoNumberStringList);

    }
    private List<Integer> makeIntList(String[] winningLottoNumberStringList) {
        List<Integer> winningLottoNumberIntList = new ArrayList<>();
        for (String stringLottoNumber : winningLottoNumberStringList) {
            winningLottoNumberIntList.add(Integer.parseInt(stringLottoNumber));
        }
        return winningLottoNumberIntList;
    }

}
