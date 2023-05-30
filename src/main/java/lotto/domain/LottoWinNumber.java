package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinNumber {

    private final List<Integer> lottoWinNumber;

    LottoWinNumber(String winNumberString) {
        String[] split = winNumberString.split(",");
        lottoWinNumber = new ArrayList<>();

        for (String s : split) {
            lottoWinNumber.add(Integer.parseInt(s.trim()));
        }
    }

    public int countMatchingNumbers(List<Integer> lottoNumbers) {
        int result = 0;

        for (Integer lottoNumber : lottoNumbers) {
            result += getMatchCount(lottoNumber);
        }

        return result;
    }

    public int getMatchCount(Integer lottoNumber) {
        return lottoWinNumber.contains(lottoNumber) ? 1 : 0;
    }
}
