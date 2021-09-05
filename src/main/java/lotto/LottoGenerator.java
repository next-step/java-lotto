package lotto;

import java.util.*;


public class LottoGenerator {
    public static final int PRICE = 1000;

    private final Random random = new Random(System.nanoTime());
    private final ArrayList<Integer> numberList = new ArrayList<>();

    public LottoGenerator() {
        for (int number = LottoNumbers.MIN_NUMBER; number <= LottoNumbers.MAX_NUMBER; number++) {
            numberList.add(number);
        }
    }

    public int getCount(int amount) {
        return amount / PRICE;
    }

    public List<Lotto> generateLotto(int amount) {
        int totalCount = getCount(amount);
        ArrayList<Lotto> lottoList = new ArrayList<>();

        for (int count = 0; count < totalCount; count++) {
            Collections.shuffle(numberList, random);
            List<Integer> lottoNumbers = new ArrayList<>(numberList.subList(0,6));
            lottoList.add(new Lotto(lottoNumbers));
        }

        return lottoList;
    }
}
