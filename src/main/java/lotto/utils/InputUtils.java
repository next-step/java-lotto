package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {

    private static int LOTTO_GAME_PRICE = 1000;
    private static final String COMMA = ",";

    public InputUtils(){
    }

    public static void validMoneyGreaterZero(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("입력 금액이 1000원 보다 작을 수 없습니다.");
        }
    }

    public static int parserMoney(int money) {
        return money / LOTTO_GAME_PRICE;
    }

    public static List stringToArray(String input) {
        if(isEmptyOrBlank(input)){
            throw new IllegalArgumentException("값이 입력되지 않았습니다.");
        }
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

    }

    private static Boolean isEmptyOrBlank(String inputName) {
        return inputName == null || inputName.trim().isEmpty();
    }

}
