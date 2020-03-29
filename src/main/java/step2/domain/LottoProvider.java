package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoProvider {

    private static final List<LottoNumber> wholeNumber = getWholeNumber();

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
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int number : inputNumbers) {
            lottoNumbers.add(new LottoNumber(number)); // TODO: 같은 값(getValue)으로 만들어진 LottoNumber 객체가 있으면 새로 안만들게 하고 싶다.
        }
        return new Lotto(lottoNumbers);
    }

    private static List<LottoNumber> getShuffledNumber() {
        List<LottoNumber> shuffledNumber = wholeNumber;
        Collections.shuffle(shuffledNumber);

        return shuffledNumber;
    }

    private static List<LottoNumber> getWholeNumber() {
        List<LottoNumber> numbers = new ArrayList<>();

        for(int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }
}
