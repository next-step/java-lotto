package lotto.domain;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.Result;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int DEFAULT_LOTTO_PRICE = 1000;
    public Lottos initLottos(int money) {
        int lottoGameCount = purchaseLottoCount(money);
        return new Lottos(lottoGameCount);
    }

    public int purchaseLottoCount(int money) {
        return money / DEFAULT_LOTTO_PRICE;
    }


    public List<Result> matches(Lotto winningLotto, int bonus, Lottos myLottos) {
        return myLottos.getLottos().stream()
                .map(myLotto -> myLotto.match(winningLotto, bonus, myLotto))
                .collect(Collectors.toList());
    }
}
