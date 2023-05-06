package lotto.util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoUtils {

    private static final int LOTTO_PRICE = 1000;
    private static final Pattern TARGET_NUMBER_PATTERN = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");


    public static int getLottoGameCount(int price) {

        isMinLottoPrice(price);

        return price / LOTTO_PRICE;
    }

    private static void isMinLottoPrice(int price) {
        if(price < LOTTO_PRICE) {
            throw new InputMismatchException("로또 최소 구매 금액은 1000원 입니다.");
        }
    }

    public static List<Integer> lottoResultNumberList(String lottoResultNumber) {
        List<Integer> numberList = Arrays.stream(lottoResultNumber.split(", "))
                .map(LottoUtils::convertNumber)
                .collect(Collectors.toList());

        return numberList;
    }

    private static int convertNumber(String number) {
        if(!isRangeOfNumber(number)) {
            throw new InputMismatchException("로또 번호는 1~45 사이 입니다.");
        }

        return Integer.parseInt(number);
    }

    private static boolean isRangeOfNumber(String number) {
        return TARGET_NUMBER_PATTERN.asMatchPredicate().test(number);
    }
}
