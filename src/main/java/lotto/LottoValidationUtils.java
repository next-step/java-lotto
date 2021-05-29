package lotto;

import lotto.exception.LottoNumberRangeException;
import lotto.exception.LottoSizeOrDuplicateException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoValidationUtils {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;

    private static final String WIN_LOTTO_NUMBER_DELIMITER = ",";
    private static final String NUMBER_REGEX = "[0-9]+$";
    private static final String NUMBER_FORMAT_EXCEPTION_MSG = "숫자만 입력 가능합니다.";
    private static final String NUMBER_NULL_EXCEPTION_MSG = "구매금액을 입력해 주세요.";

    public static final int LOTTO_COST = 1000;

    public static int getLottoNumberSize(){
        return LOTTO_NUMBER_SIZE;
    }

    public static List<Integer> lottoNumberRange() {
        return IntStream.rangeClosed(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void validationLottoNumber(List<Integer> lottoNumber) {
        Set<Integer> checkNumber = new HashSet<>(lottoNumber);
        if (checkNumber.size() != LOTTO_NUMBER_SIZE || lottoNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new LottoSizeOrDuplicateException(LOTTO_NUMBER_SIZE);
        }
    }

    public static List<Integer> lottoNumberToList(String winNumber) {
        if(winNumber.equals("")){
            throw new NumberFormatException(NUMBER_NULL_EXCEPTION_MSG);
        }
        String[] winNumberArr = winNumber.replaceAll(" ", "").split(WIN_LOTTO_NUMBER_DELIMITER);
        List<Integer> winNumbers = new ArrayList<>();
        for(String number : winNumberArr) {
            checkNumberAndRange(number);
            winNumbers.add(Integer.parseInt(number));
        }
        validationLottoNumber(winNumbers);
        return winNumbers;
    }

    public static void checkNumberAndRange(String winNumberArr) {
        if(!winNumberArr.matches(NUMBER_REGEX)) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MSG);
        }
        if(Integer.parseInt(winNumberArr) < LOTTO_MINIMUM_NUMBER || Integer.parseInt(winNumberArr) > LOTTO_MAXIMUM_NUMBER){
            throw new LottoNumberRangeException(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER);
        }
    }
}
