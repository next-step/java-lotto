package study.step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static List<LottoNumber> allLottoNumbers = new ArrayList<>();

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
            .forEach(i -> allLottoNumbers.add(LottoNumber.of(i)));
    }

    private static Lotto createLotto() {
        Collections.shuffle(allLottoNumbers);
        return new Lotto(allLottoNumbers.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toList()));
    }

    public static Lottos purchase(int amount) {
        Lottos lottoList = new Lottos();
        int count = amount / LOTTO_PRICE;
        for(int i=0; i<count; i++) {
            lottoList.add(createLotto());
        }
        return lottoList;
    }
}
