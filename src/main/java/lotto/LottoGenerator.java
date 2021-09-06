package lotto;

import java.util.*;


public class LottoGenerator {
    private final Random random = new Random(System.nanoTime());

    public Lottos generateLotto(int totalCount) {
        List<Integer> numbersPool = new ArrayList<>(LottoNumbersPool.pool);
        ArrayList<Lotto> lottoList = new ArrayList<>();

        for (int count = 0; count < totalCount; count++) {
            Collections.shuffle(numbersPool, random);
            List<Integer> numbers = new ArrayList<>(numbersPool.subList(0,6));
            LottoNumbers lottoNumbers = new LottoNumbers(numbers);
            lottoList.add(new Lotto(lottoNumbers));
        }
        return new Lottos(lottoList);
    }
}
