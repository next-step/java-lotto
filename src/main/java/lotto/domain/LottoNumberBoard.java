package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By mand2 on 2020-11-19.
 * 선택하기 위한 로또 판 1~45 사이의 수가 fix되어 있음.
 */
public class LottoNumberBoard {

    private static final List<Integer> lottoNumbers = new ArrayList<>();;
    public static final int VALID_MIN_NUMBER = 1;
    public static final int VALID_MAX_NUMBER = 45;

    static {
        for (int i = VALID_MIN_NUMBER; i <= VALID_MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }


    private LottoNumberBoard() {
    }

    public static List<Integer> lottoNumberBoard() {
        return lottoNumbers;
    }
}
