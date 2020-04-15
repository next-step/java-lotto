package lotto.domain;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    public Lottos initLottos(int money) {
        return new Lottos(money);
    }

    public List<Result> matches(Lotto winningLotto, int bonus, Lottos myLottos) {
        return myLottos.getLottos().stream()
                .map(myLotto -> myLotto.match(winningLotto, bonus))
                .collect(Collectors.toList());
    }
}
