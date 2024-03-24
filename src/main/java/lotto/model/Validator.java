package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    private final List<Integer> lotto;

    public Validator(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static int validatePurchaseAmount(String purchaseAmount)  {
        int purchaseCount = Integer.parseInt(purchaseAmount) / 1000;

        if (purchaseCount < 1) {
            throw new IllegalArgumentException("로또는 장당 1000원입니다. 입력한 금액으로 구매 불가합니다.");
        }

        return purchaseCount;
    }

    public static void validateLotto(List<Integer> lotto) {
        if (!isValidLottoSize(lotto) || !isNotDuplicatedNumbers(lotto) || !isValidLottoNumbers(lotto)) {
            throw new IllegalArgumentException("로또 번호는 총 6개이고 각 번호는 1 ~ 45 사이의 값만 가능합니다.");
        }
    }

    public static boolean isValidLottoSize(List<Integer> winNumbers) {

        return winNumbers.size() == 6;
    }

    private static boolean isNotDuplicatedNumbers(List<Integer> lottoNumers) {
        Set<Integer> numbers = lottoNumers.stream().collect(Collectors.toSet());
        return numbers.stream().distinct().count() == lottoNumers.size();    }

    public static boolean isValidLottoNumbers(List<Integer> lottoNumers) {
        Collections.sort(lottoNumers);
        return isNumberInValidRange(lottoNumers.get(0)) && isNumberInValidRange(lottoNumers.get(6 - 1));
    }

    public static boolean isNumberInValidRange(int number) {
        return number >= 1 && number <= 45;
    }

    public static List<Integer> parseLottoNumbers(String value) {
        List<Integer> lotto = convertStringToIntegers(value);
        validateLotto(lotto);
        return lotto;
    }

    public static List<Integer> convertStringToIntegers(String input) {
        String[] values = splitNumbersByComma(input);
        return stringsToListInteger(values);
    }

    public static List<Integer> stringsToListInteger(String[] values) {
        return Arrays.stream(values).map(Integer::valueOf).collect(Collectors.toList());
    }

    public static String[] splitNumbersByComma(String input) {
        return input.split(",");
    }
}
