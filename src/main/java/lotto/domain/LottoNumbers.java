package lotto.domain;

import lotto.Utils;

import java.util.*;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Integer[] lottoNumbers) {
        Set<LottoNumber> inputNumbers = new HashSet<>();
        for(Integer number : lottoNumbers) {
            inputNumbers.add(new LottoNumber(number));
        }
        this.lottoNumbers = inputNumbers;
        checkNumberSize(inputNumbers);
    }

    private void checkNumberSize(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    int size() {
        return lottoNumbers.size();
    }

    int matchCount(LottoNumbers luckyNumbers) {
        int matchCount = 0;
        for (LottoNumber number : lottoNumbers) {
            matchCount += luckyNumbers.contains(number);
        }

        return matchCount;
    }

    int contains(LottoNumber lottoNumber) {
        int result = 0;
        for(LottoNumber number : lottoNumbers) {
            result += number.compareNumber(lottoNumber);
        }
        return result;
    }

    public String printLottoNumbers() {
        List<Integer> sortNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            sortNumbers.add(Utils.toInt(lottoNumber.printLottoNumber()));
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
        /*for (LottoNumber lottoNumber : lottoNumbers) {
            b.append(lottoNumber.printLottoNumber());
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }*/

        return null;
    }
}
