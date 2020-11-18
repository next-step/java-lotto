package lotto.domain;

import lotto.domain.game.LottoNumber;

import java.util.Collections;
import java.util.List;

/**
 * Created By mand2 on 2020-11-19.
 * 로또 번호 6개 자동 생성하는 객체
 */
public class LottoNumberMaker {

    private LottoNumberMaker() {}


    // TODO 로또객체로 반환.
    public static List<Integer> shuffle() {
        List<Integer> board = new LottoNumberBoard().lottoNumberBoard();
        Collections.shuffle(board);

        return board.subList(0, LottoNumber.VALID_LOTTO_SIZE);
    }

    public static void shuffle(int round) {
        for (int i = round; i > 0; i--) {
            shuffle();
        }
    }

}
