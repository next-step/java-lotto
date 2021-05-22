package lotto;

import java.util.ArrayList;
import java.util.List;

public class LastWonLottoNumber {
    private List<Integer> lastWonLottoNumbers;

    public LastWonLottoNumber(String inputLastWonLottoNumberString) {
        lastWonLottoNumbers = new ArrayList<Integer>();
        lastWonLottoNumbers = parsingInputString(inputLastWonLottoNumberString);
    }

    private List<Integer> parsingInputString(String inputLastWonLottoNumberString) {
        String [] numbers = inputLastWonLottoNumberString.split(",");
        for(int i=0; i<numbers.length; i++) {
            lastWonLottoNumbers.add(Integer.parseInt(numbers[i]));
        }
        return lastWonLottoNumbers;
    }

    public boolean contains(int number) {
        return lastWonLottoNumbers.contains(number);
    }
}
