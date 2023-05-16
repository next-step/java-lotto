package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLotto(int price) {
        return Stream.generate(Lotto::new)
                .limit(price / LOTTO_PRICE)
                .collect(Collectors.toList());
    }
}
