package lotto.domain;

import lotto.exception.IllegalLottoNumberException;
import lotto.exception.IllegalSeparateException;
import lotto.util.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SeparateNumber {

    private static final Pattern SEPARATE_PATTERN = Pattern.compile(",");
    private final List<Integer> lottoNumbers;

    private SeparateNumber(String separateStr) {
        if (!isValid(separateStr)) {
            throw new IllegalSeparateException();
        }
        this.lottoNumbers = toLottoNumbers(separateStr);
    }

    public static SeparateNumber of(String separateStr) {
        return new SeparateNumber(separateStr);
    }

    public List<Integer> initLottoNumbers() {
        return lottoNumbers;
    }

    private boolean isValid(String separateStr) {
        return SEPARATE_PATTERN.matcher(separateStr).find();
    }

    private List<Integer> toLottoNumbers(String separateStr) {
        String[] split = SEPARATE_PATTERN.split(separateStr);
        List<Integer> result = new ArrayList<>();
        for (String strNumber : split) {
            int number = Integer.parseInt(strNumber);
            validationLottoNumber(number);
            result.add(number);
        }

        return result;
    }

    private void validationLottoNumber(int number) {
        if (!LottoNumber.isValidLottoNumber(number)) {
            throw new IllegalLottoNumberException(number);
        }
    }
}