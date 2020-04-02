package lotto.lottogenerator;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoNumber;
import lotto.view.input.StringConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.model.lotto.LottoNumber.LOTTO_NUMBER_MAX;
import static lotto.model.lotto.LottoNumber.LOTTO_NUMBER_MIN;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final List<LottoNumber> LOTTO_NUMBER_POOL = new ArrayList<>();

    static {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            LOTTO_NUMBER_POOL.add(LottoNumber.of(i));
        }
    }

    public static List<Lotto> getLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(getLotto());
        }
        return lottos;
    }

    public static List<Lotto> getLottos(List<String> stringLottos) {
        return stringLottos.stream()
                .map(stringLotto -> getLotto(stringLotto))
                .collect(toList());
    }

    private static Lotto getLotto() {
        Collections.shuffle(LOTTO_NUMBER_POOL);

        return LOTTO_NUMBER_POOL.stream()
                .limit(LOTTO_SIZE)
                .sorted(comparingInt(LottoNumber::getLottoNumber))
                .collect(collectingAndThen(toList(), Lotto::new));
    }

    private static Lotto getLotto(String stringLotto) {
        List<LottoNumber> lottoNumbers = StringConverter.convertStringToNumbers(stringLotto)
                .stream()
                .sorted(comparing(LottoNumber::getLottoNumber))
                .collect(toList());
        return new Lotto(lottoNumbers);
    }
}