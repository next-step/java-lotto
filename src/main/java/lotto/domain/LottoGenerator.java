package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_RANGE = 45;

    public List<Lotto> generate(int money) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i<countTryNumber(money); i++){
            lottos.add(randomGenerate());
        }

        return lottos;
    }

    private int countTryNumber(int money) {
        return money/LOTTO_PRICE;
    }


    private Lotto randomGenerate() {

        List<Integer> numberList = new ArrayList<>();
        IntStream.range(1,LOTTO_RANGE+1).forEach(i -> numberList.add(i));
        Collections.shuffle(numberList);
        return new Lotto(numberList.subList(0,LOTTO_LENGTH));

    }
}
