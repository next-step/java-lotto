package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoProvider {

    private static final List<LottoNumber> wholeNumber = new ArrayList<>();

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

    public static Lotto createLotto(List<Integer> inputNumbers) {
        List<LottoNumber> lotto =  inputNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(lotto);
    }

    private static List<LottoNumber> getShuffledNumber() {
        List<LottoNumber> shuffledNumber = new ArrayList<>(getWholeNumber());

        Collections.shuffle(shuffledNumber);
        return shuffledNumber;
    }

    private static List<LottoNumber> getWholeNumber() {
        if(wholeNumber.isEmpty()) {
            for(int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
                wholeNumber.add(new LottoNumber(i));
            }
        }
        return wholeNumber;
    }
}
