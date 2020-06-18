package utils;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class IntegerUtils {
    public static int parsing(String calcStr) {
        try {
            int num = Integer.parseInt(calcStr);
            return num;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public static int[] splitAndParseInt(String stringNumbers) {
        String[] numbers = stringNumbers.split(",");
        int size = numbers.length;
        int[] results = new int[size];

        for (int i = 0; i < size; i++) {
            results[i] = IntegerUtils.parsing(numbers[i].trim());
        }

        return results;
    }

    public static LottoNumbers splitAndParseLottoNumber(String stringNumbers) {
        String[] numbers = stringNumbers.split(",");
        int size = numbers.length;
        LottoNumber[] lottoNumbers = new LottoNumber[size];

        for (int i = 0; i < size; i++) {
            lottoNumbers[i] = new LottoNumber(parsing(numbers[i]));
        }

        return new LottoNumbers(lottoNumbers);
    }

    public static List<Integer> arrToList(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }

        return list;
    }

    public static List<Integer> numbersToList(LottoNumber[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (LottoNumber number : numbers) {
            list.add(number.getNumber());
        }

        return list;
    }
}
