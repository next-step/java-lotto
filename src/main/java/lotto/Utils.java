package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;

import java.util.*;

public class Utils {
    public static String[] stringSplitWithDelimiter(String original, String delimiter) {
        original = original.replaceAll("\\s", "");
        return original.split(delimiter);
    }

    public static String printLottoNumbers(Set<LottoNumber> lottoNumbers) {
        List<Integer> sortNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            sortNumbers.add(Integer.parseInt(lottoNumber.toString()));
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
        LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.getInstance();
        Set<LottoNumber> inputNumbres = new HashSet<>();
        for (Integer i : arrays) {
            LottoNumber lottoNumber = lottoNumberGenerator.valueOf(i);
            inputNumbres.add(lottoNumber);
        }
        return inputNumbres;
    }

    public static Set<LottoNumber> arrayToSet(String[] arrays) {
        Integer[] tmp = Arrays.stream(arrays)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.getInstance();
        Set<LottoNumber> inputNumbres = new HashSet<>();
        for (Integer i : tmp) {
            LottoNumber lottoNumber = lottoNumberGenerator.valueOf(i);
            inputNumbres.add(lottoNumber);
        }
        return inputNumbres;
    }
}
