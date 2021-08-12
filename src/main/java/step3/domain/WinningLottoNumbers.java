package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class WinningLottoNumbers {
    private static final int numOfWinningLottoNumber = 6;
    private static final String winningLottoNumberErrorMessage = "당첨 번호는 6개로 구성되어야 하며, ', ' 을 이용하여 구분하고 있습니다.";

    public ArrayList<Integer> checkValidInput(String s) {
        String[] winningLottoNumberStringList = s.split(", ");
        if (winningLottoNumberStringList.length != numOfWinningLottoNumber) {
            throw new IllegalArgumentException(winningLottoNumberErrorMessage);
        }
        return makeIntList(winningLottoNumberStringList);

    }
    private ArrayList<Integer> makeIntList(String[] winningLottoNumberStringList) {
        ArrayList<Integer> winningLottoNumberIntList = new ArrayList<>();
        for (String stringLottoNumber : winningLottoNumberStringList) {
            winningLottoNumberIntList.add(Integer.parseInt(stringLottoNumber));
        }
        return winningLottoNumberIntList;
    }

}
