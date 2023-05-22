package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyRandomLotto(int money) {
        return Stream.generate(Lotto::new)
                .limit(money / LOTTO_PRICE)
                .collect(Collectors.toList());
    }

    public List<Lotto> buyManualAndRandomLotto(int money, List<String> lottos) {
        if (money < lottos.size() * LOTTO_PRICE){
            throw new IllegalArgumentException("돈이 부족 합니다");
        }
        return lottos.stream()
                .map(Lotto::createManual)
                .collect(Collectors.toList());
    }
}
