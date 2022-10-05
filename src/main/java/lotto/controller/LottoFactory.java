package lotto.controller;

import lotto.domain.Lotto;

@FunctionalInterface
public interface LottoFactory {
    Lotto lotto();
}
