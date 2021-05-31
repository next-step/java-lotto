package lotto.domain;
/*

import lotto.common.Constant;
import lotto.common.MessageCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberManualGenerator implements LottoNumberGeneratorStrategy {
    String manualLottoNumber;

    public LottoNumberManualGenerator(String manualLottoNumbers) {
        this.manualLottoNumber = manualLottoNumbers;
    }

    public List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = parsingInputString(manualLottoNumber);
        return lottoNumbers;
    }

    private List<Integer> parsingInputString(String lottoNumber) {
        String[] numbers = lottoNumber.split(",");
        for (int i = 0; i < numbers.length; i++) {
            lastWonLottoNumbers.add(validateNumber(numbers[i]));
        }
        return lastWonLottoNumbers;
    }

    private int validateNumber(String splitNumber) {
        if (!isNumeric(splitNumber))
            throw new RuntimeException(MessageCode.INVALID_LOTTO_NUMBER_TYPE.message());

        int number = Integer.parseInt(splitNumber);
        if (number > Constant.MAX_LOTTO_NUMBER.value())
            throw new RuntimeException(MessageCode.INVALID_LOTTO_NUMBER_RANGE.message());

        return number;
    }


    private boolean isNumeric(String splitNumber) {
        return splitNumber.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public boolean containsMain(int number) {
        return lastWonLottoNumbers.contains(number);
    }
}
*/