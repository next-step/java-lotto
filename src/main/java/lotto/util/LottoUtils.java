package lotto.util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoUtils {

    private static final int LOTTO_PRICE = 1000;
    private static final Pattern TARGET_NUMBER_PATTERN = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");
    private static final int LOTTO_NUMBER_SIZE = 6;

    public static int getLottoGameCount(int price) {

        if(isMinLottoPrice(price)){
            lottoException("로또 최소 구매 금액은 1000원 입니다.");
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
            lottoException("로또 번호는 숫자 6개만 입력됩니다.");
        }

        return numberList;
    }

    private static int convertNumber(String number) {
        if(!isRangeOfNumber(number)) {
            lottoException("로또 번호는 1~45 사이 입니다.");
        }

        return Integer.parseInt(number);
    }

    private static boolean isRangeOfNumber(String number) {
        return TARGET_NUMBER_PATTERN.asMatchPredicate().test(number);
    }

    private static boolean isLottoResultNumberSize(List<Integer> numberList) {
        return numberList.size() == LOTTO_NUMBER_SIZE;
    }

    private static void lottoException(String msg) {
        throw new InputMismatchException(msg);
    }
}
