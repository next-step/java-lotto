package lotto.domain;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created By mand2 on 2020-11-19.
 * 로또 번호 6개 자동 생성하는 객체
 */
public class LottoGenerator {

    private LottoGenerator() {}

    private static LottoNumber shuffle() {
        List<Integer> board = new LottoNumberBoard().lottoNumberBoard();
        Collections.shuffle(board);

        return LottoNumber.of(board.subList(0, LottoNumber.VALID_LOTTO_SIZE));
    }

    public static Lottos generate(int round) {
        List<Lotto> lottos = Stream.generate(() -> Lotto.of(shuffle()))
                .limit(round)
                .collect(Collectors.toList());

        return Lottos.of(lottos);
    }

}
