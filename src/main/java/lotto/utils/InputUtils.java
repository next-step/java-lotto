package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputUtils {

    private static int LOTTO_GAME_PRICE = 1000;
    private static final String COMMA = ",";

    public void validMoneyGreaterZero(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("입력 금액이 0보다 작을 수 없습니다.");
        }
    }

    public int parserMoney(int money) {
        return money / LOTTO_GAME_PRICE;
    }

    public static List stringToArray(String input) {
        isEmpty(input);
        List<Integer> parsingNumbers = Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        if(parsingNumbers.size() > 6){
            throw new IllegalArgumentException("당첨 번호는 6개 이상 입력 할 수 없습니다.");
        }

        for (int number: parsingNumbers) {
            inputLottoNumberCheck(number);
        }

        return parsingNumbers;
    }

    public static void isEmpty(String inputName) {
        if (isBlank(inputName)) {
            throw new IllegalArgumentException("번호가 입력되지 않았습니다.");
        }
    }

    private static boolean isBlank(String inputName) {
        return inputName == null || inputName.trim().isEmpty();
    }

    private static void inputLottoNumberCheck(int number){
        if(number > 45){
            throw new IllegalArgumentException("로또 번호는 45보다 클 수 없습니다.");
        }
    }

}
