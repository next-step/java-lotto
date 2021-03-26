package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static List<LottoNumber> allLottoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> allLottoNumbers.add(new LottoNumber(number)));
    }

    private LottoStore(){
    }

    private static Lotto createLotto() {
        Collections.shuffle(allLottoNumbers);
        Lotto lotto = new Lotto(allLottoNumbers.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList()));
        return lotto;
    }

    public static Lottos purchase(Money money) {
        Lottos lottos = new Lottos();
        long lottoCount = money.LottoCount();
        for(int i = 0; i < lottoCount; i++) {
            lottos.addLotto(createLotto());
        }
        return lottos;
    }
}
