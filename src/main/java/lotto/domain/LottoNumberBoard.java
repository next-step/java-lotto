package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created By mand2 on 2020-11-19.
 * 선택하기 위한 로또 판 1~45 사이의 수가 fix되어 있음.
 */
public class LottoNumberBoard {

    private static List<Integer> lottoNumbers;
    public static final int VALID_MIN_NUMBER = 1;
    public static final int VALID_MAX_NUMBER = 45;

    static {
        lottoNumbers = IntStream.rangeClosed(VALID_MIN_NUMBER, VALID_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }


    private LottoNumberBoard() {
    }

    public static List<Integer> lottoNumberBoard() {
        return lottoNumbers;
    }
}
