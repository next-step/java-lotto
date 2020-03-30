package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoProvider {

    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private LottoProvider() {}

    public static Lottos createLottos(int lottoCount) {
        List<Lotto> createdLottos = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++) {
            createdLottos.add(createLotto());
        }
        Lottos lottos = new Lottos(createdLottos);

        return lottos;
    }

    private static Lotto createLotto() {
        List<LottoNumber> lotto = getShuffledNumber()
                .stream()
                .limit(Lotto.COUNT_NUMBER)
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(lotto);
    }

    private static List<LottoNumber> getShuffledNumber() {
        List<LottoNumber> shuffledNumber = LOTTO_NUMBER_POOL;

        Collections.shuffle(shuffledNumber);
        return shuffledNumber;
    }

    public static Lotto createLotto(List<Integer> inputNumbers) {
        List<LottoNumber> lotto =  inputNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(lotto);
    }


}
