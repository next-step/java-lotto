package step2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoProvider {

    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(toList());

    private LottoProvider() {}

    public static List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    public static List<Lotto> createLottos(List<List<Integer>> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();

        for(List<Integer> manualLotto : manualLottos) {
            lottos.add(createLotto(manualLotto));
        }

        return lottos;
    }

    private static Lotto createLotto() {
        return getShuffledNumber()
                .stream()
                .limit(Lotto.COUNT_NUMBER)
                .sorted()
                .collect(collectingAndThen(toList(), Lotto::new));
    }

    private static List<LottoNumber> getShuffledNumber() {
        List<LottoNumber> shuffledNumber = LOTTO_NUMBER_POOL;

        Collections.shuffle(shuffledNumber);
        return shuffledNumber;
    }

    public static Lotto createLotto(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .map(LottoNumber::new)
                .collect(collectingAndThen(toList(), Lotto::new));
    }

    public static WinningLotto createWinningLotto(List<Integer> inputNumbers, int bonusNumber) {
        List<LottoNumber> lottoNumbers = inputNumbers.stream()
                .map(LottoNumber::new)
                .collect(toList());

        return new WinningLotto(new Lotto(lottoNumbers), new LottoNumber(bonusNumber));
    }
}
