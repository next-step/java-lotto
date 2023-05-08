package lotto.domian;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoCompany {

    public static final int PURCHASE_UNIT = 1000;
    private static final String SPLIT_DELIMITER = ",";

    public static WinNumber announce(String answerNumbers) {
        String[] splitedNumbers = splitNumbers(answerNumbers);
        List<Integer> numberList = getIntegers(splitedNumbers);
        return new WinNumber(new Lotto(makeLottoNumber(numberList)));
    }

    private static String[] splitNumbers(String winnerNumbers) {
        return winnerNumbers.trim().split(SPLIT_DELIMITER);
    }

    private static List<Integer> getIntegers(String[] splitedNumbers) {
        return Stream.of(splitedNumbers)
                .map(string -> {
                    string = string.trim();
                    isNumeric(string);
                    return Integer.parseInt(string);
                })
                .collect(Collectors.toList());
    }

    private static void isNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("로또 번호는 숫자형태만 가능합니다.");
        }
    }

    private static Set<LottoNumber> makeLottoNumber(List<Integer> numberList) {
        return numberList.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toSet());
    }

}
