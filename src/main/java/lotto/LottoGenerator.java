package lotto;

import java.util.*;


public class LottoGenerator {
    private final Random random = new Random(System.nanoTime());

    public Lottos generateLotto(int totalCount) {
        List<LottoNumber> numbersPool = new ArrayList<>(LottoNumbersPool.pool);
        ArrayList<Lotto> lottoList = new ArrayList<>();

        for (int count = 0; count < totalCount; count++) {
            Collections.shuffle(numbersPool, random);
            List<LottoNumber> numbers = new ArrayList<>(numbersPool.subList(0,6));
            lottoList.add(new Lotto(numbers));
        }
        return new Lottos(lottoList);
    }
}
