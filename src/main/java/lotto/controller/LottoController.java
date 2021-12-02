package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    public static List<Lotto> buyLotto(Money money) {
        return IntStream.range(0, money.getBuyableLottoCount())
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }
}
