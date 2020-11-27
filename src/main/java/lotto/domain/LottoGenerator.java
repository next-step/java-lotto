package lotto.domain;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumberSet;
import lotto.domain.game.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created By mand2 on 2020-11-19.
 * 로또 번호 6개 자동 생성하는 객체
 */
public class LottoGenerator {

    private static List<Integer> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LottoNumber.VALID_MIN_NUMBER, LottoNumber.VALID_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private LottoGenerator() {}

    public static Lottos generate(int round) {
        List<Lotto> lottos = Stream.generate(() -> Lotto.of(automateLotto()))
                .limit(round)
                .collect(Collectors.toList());

        return Lottos.of(lottos);
    }

    private static LottoNumberSet automateLotto() {
        return LottoNumberSet.of(convert());
    }

    private static List<LottoNumber> convert() {
        shuffle();
        List<Integer> before = subList();

        return before.stream().map(LottoNumber::from).collect(Collectors.toList());
    }

    private static void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    private static List<Integer> subList() {
        return lottoNumbers.subList(0, LottoNumberSet.VALID_LOTTO_SIZE);
    }
}
