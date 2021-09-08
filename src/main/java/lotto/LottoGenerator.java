package lotto;

import java.util.*;
import java.util.stream.Collectors;


public class LottoGenerator {
    private final static Random random = new Random(System.nanoTime());

    public static Lottos generateAutoLottos(int totalCount) {
        ArrayList<Lotto> lottoList = new ArrayList<>();
        for (int count = 0; count < totalCount; count++) {
            lottoList.add(generateAutoLotto());
        }
        return new Lottos(lottoList);
    }

    public static Lotto generateAutoLotto() {
        List<LottoNumber> numbersPool = new ArrayList<>(LottoNumbersPool.pool);
        Collections.shuffle(numbersPool, random);
        List<LottoNumber> numbers = new ArrayList<>(numbersPool.subList(0,6));
        return new Lotto(numbers);
    }

    public static Lotto generateManualLotto(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}
