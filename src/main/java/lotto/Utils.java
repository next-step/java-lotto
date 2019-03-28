package lotto;

import lotto.domain.LottoNumber;

import java.util.*;

public class Utils {
    public static int toInt(String purchase) {
        return Integer.parseInt(purchase);
    }

    public static String[] stringSplitWithDelimiter(String original, String delimiter) {
        original = original.replaceAll("\\s", "");
        return original.split(delimiter);
    }

    public static String printLottoNumbers(Set<LottoNumber> lottoNumbers) {
        List<Integer> sortNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            sortNumbers.add(Utils.toInt(lottoNumber.toString()));
        }
        Collections.sort(sortNumbers);
        if (lottoNumbers == null)
            return "null";
        int iMax = lottoNumbers.size() - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        for (Integer number : sortNumbers) {
            b.append(number);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }

        return null;
    }

    public static Set<LottoNumber> arraysToSet(Integer[] arrays) {
        Set<LottoNumber> inputNumbers = new HashSet<>();
        for(Integer number : arrays) {
            inputNumbers.add(new LottoNumber(number));
        }

        return inputNumbers;
    }
}
