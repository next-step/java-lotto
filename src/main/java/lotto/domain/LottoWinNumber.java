package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinNumber {

    private final List<Integer> lottoWinNumber;

    // 문자열을 당첨문자열로 변경
    LottoWinNumber(String winNumberString) {
        String[] split = winNumberString.split(",");
        lottoWinNumber = new ArrayList<>();

        for (String s : split) {
            lottoWinNumber.add(Integer.parseInt(s.trim()));
        }
    }

    // 당첨번호와 일치하는 개수 카운트
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
