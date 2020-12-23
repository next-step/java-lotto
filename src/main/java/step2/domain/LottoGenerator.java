package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(toList());

    private LottoGenerator() {}

    public static Lottos generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        while(count > 0) {
            lottos.add(generateLotto());
            count--;
        }

        return new Lottos(lottos);
    }

    private static Lotto generateLotto() {
        Collections.shuffle(LOTTO_NUMBER_POOL);

        List<LottoNumber> lottoNumbers = LOTTO_NUMBER_POOL.stream()
                .limit(6)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    public static Lotto generateLotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    public static WinningLotto generateWinningLotto(List<Integer> numbers, int bonusNumber) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(toList());

        return new WinningLotto(new Lotto(lottoNumbers), new LottoNumber(bonusNumber));
    }
}
