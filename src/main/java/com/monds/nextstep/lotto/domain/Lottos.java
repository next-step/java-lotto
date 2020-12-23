package com.monds.nextstep.lotto.domain;

import java.util.*;
import java.util.function.IntFunction;

import static com.google.common.base.Preconditions.checkArgument;
import static com.monds.nextstep.lotto.domain.LottoErrorMessage.*;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;
    private final int manualCount;

    public Lottos(int size, List<Lotto> manualLottos) {
        lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(LottoGenerator.shuffleAndGet());
        }
        lottos.addAll(manualLottos);
        manualCount = manualLottos.size();
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return lottos.size() - manualCount;
    }

    public static int calculateHowMuch(int lottoCount) {
        return lottoCount * LOTTO_PRICE;
    }

    public List<Lotto> getAll() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        Map<LottoRanking, Integer> countByRanking = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRanking ranking = winningLotto.matching(lotto);
            countByRanking.put(ranking, countByRanking.getOrDefault(ranking, 0) + 1);
        }
        return new LottoResult(lottos.size(), countByRanking);
    }

    public static class Builder {

        private final int money;
        private List<Lotto> manualLottos = Collections.emptyList();

        public Builder(int money) {
            checkArgument(money > 0, MONEY_ERROR_MESSAGE, money);
            checkArgument(money % LOTTO_PRICE == 0, MONEY_UNIT_MESSAGE, LOTTO_PRICE, money);

            this.money = money;
        }

        public Builder ifBuyManual(int manualCount, IntFunction<List<Lotto>> lottoSupplier) {
            checkArgument(manualCount >= 0, COUNT_ERROR_MESSAGE, manualCount);
            checkArgument(money / LOTTO_PRICE >= manualCount, NOT_ENOUGH_MONEY_MESSAGE);

            if (manualCount > 0) {
                manualLottos = lottoSupplier.apply(manualCount);
            }
            return this;
        }

        public Lottos build() {
            return new Lottos(money / LOTTO_PRICE - manualLottos.size(), manualLottos);
        }
    }
}
