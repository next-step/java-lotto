package lotto.controller.strategy;

import lotto.domain.Lotto;

// TODO: 컨트롤러 바깥으로 이동
public interface GenerateStrategy {
    Lotto generateLotto();
}
