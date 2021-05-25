package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoValidationUtils {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MINIMUN_NUMBER = 1;
    private static final int LOTTO_MAXINUM_NUMBER = 45;

    private static final String WIN_LOTTO_NUMBER_DELIMETER = ",";
    private static final String NUMBER_REGEX = "[+-]?[0-9]+$";
    private static final String NUMBER_RANGE_EXECEPTION_MSG = "숫자는 1부터 45까지만 입력 가능합니다.";
    private static final String NUMBER_FORMAT_EXECEPTION_MSG = "숫자만 입력 가능합니다.";
    private static final String NUMBER_NULL_EXECEPTION_MSG = "구매금액을 입력해 주세요.";

    public static final int LOTTO_COST = 1000;

    public static int getLottoNumberSize(){
        return LOTTO_NUMBER_SIZE;
    }

    public static List<Integer> lottoNumberRange() {
        return IntStream.rangeClosed(LOTTO_MINIMUN_NUMBER, LOTTO_MAXINUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void validationLottoNumber(List<Integer> lottoNumber) {
        Set<Integer> checkNumber = new HashSet<>(lottoNumber);
        if (checkNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자의 갯수는 " + LOTTO_NUMBER_SIZE + "개 입니다");
        }
    }

    public static List<Integer> lottoNumberToList(String winNumber) {
        if(winNumber.equals("")){
            throw new NumberFormatException(NUMBER_NULL_EXECEPTION_MSG);
        }
        winNumber = winNumber.replace(" ", "");
        String[] winNumberArr = winNumber.split(WIN_LOTTO_NUMBER_DELIMETER);
        List<Integer> winNumberList = new ArrayList<>();
        for(String number : winNumberArr) {
            checkNumberAndRange(number);
            winNumberList.add(Integer.parseInt(number));
        }
        validationLottoNumber(winNumberList);
        return winNumberList;
    }

    private static void checkNumberAndRange(String winNumberArr) {
        if(!winNumberArr.matches(NUMBER_REGEX)) {
            throw new NumberFormatException(NUMBER_FORMAT_EXECEPTION_MSG);
        }
        if(Integer.parseInt(winNumberArr) < LOTTO_MINIMUN_NUMBER || Integer.parseInt(winNumberArr) > LOTTO_MAXINUM_NUMBER){
            throw new IllegalArgumentException(NUMBER_RANGE_EXECEPTION_MSG);
        }
    }
}
