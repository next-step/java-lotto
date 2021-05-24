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
        String[] numbers = inputLastWonLottoNumberString.split(",");
        for (int i = 0; i < numbers.length; i++) {
            lastWonLottoNumbers.add(validateNumber(numbers[i]));
        }
        return lastWonLottoNumbers;
    }

    private int validateNumber(String splitNumber) {
        if (!isNumeric(splitNumber))
            throw new RuntimeException("숫자만 입력 가능합니다.");

        int number = Integer.parseInt(splitNumber);
        if (number > 45)
            throw new RuntimeException("1부터 45까지 숫자만 입력 가능합니다.");

        return number;
    }

    private boolean isNumeric(String splitNumber) {
        return splitNumber.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public boolean contains(int number) {
        return lastWonLottoNumbers.contains(number);
    }

    public List<Integer> getLastWonLottoNumbers() {
        return lastWonLottoNumbers;
    }
}
