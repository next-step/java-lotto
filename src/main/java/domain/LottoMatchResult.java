package domain;

import java.util.*;

public class LottoMatchResult {

    private static Integer[] countsOfWinningResult;

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교하여 당첨 번호 갯수 확인
    public static Integer[] getCountsWinningResult(ArrayList<LottoNumber> lottoNumber, int[] winnigNumber, int price) {
        countsOfWinningResult = new Integer[lottoNumber.size()];
        for (int i = 0; i < lottoNumber.size(); i++) {
            countsOfWinningResult[i] = lottoNumber.get(i).compareWinningNumber(winnigNumber);
        }
        return countsOfWinningResult;
    }
}
