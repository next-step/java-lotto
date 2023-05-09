package lotto.util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoUtils {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static int getLottoGameCount(int price) {

        if(isMinLottoPrice(price)){
            throw new InputMismatchException("로또 최소 구매 금액은 1000원 입니다. 입력값 : " + price);
        }

        return price / LOTTO_PRICE;
    }

    private static boolean isMinLottoPrice(int price) {
        return price < LOTTO_PRICE;
    }

    public static List<Integer> lottoResultNumberList(String lottoResultNumber) {
        List<Integer> numberList = Arrays.stream(lottoResultNumber.split(", "))
                .map(LottoUtils::convertNumber)
                .sorted()
                .collect(Collectors.toList());

        if(!isLottoResultNumberSize(numberList)){
            throw new IllegalArgumentException("로또 번호는 숫자 6개만 입력됩니다. 입력값 : " + numberList);
        }

        return numberList;
    }

    private static int convertNumber(String number) {
        if(!isRangeOfNumber(Integer.parseInt(number))) {
            throw new InputMismatchException("로또 번호는 1~45 사이 입니다. 입력값 : " + number);
        }

        return Integer.parseInt(number);
    }

    private static boolean isRangeOfNumber(int number) {
        return (LOTTO_MIN_NUMBER <= number && number <= LOTTO_MAX_NUMBER);
    }

    private static boolean isLottoResultNumberSize(List<Integer> numberList) {
        return numberList.size() == LOTTO_NUMBER_SIZE;
    }

    public static List<Integer> initLottoNumbers() {
        return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static double calRateOfReturn(int totalWinningPrice, int buyPrice) {

        return 1 + (totalWinningPrice - buyPrice) / (double) buyPrice;
    }

    public static boolean isResultNumContainBonusNum(List<Integer> numbers, int bonusNum) {

        return numbers.contains(bonusNum);
    }
}
