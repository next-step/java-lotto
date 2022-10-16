package lottoGame.model.strategy;

import lottoGame.model.strategy.LottoStrategy;

import java.util.List;

public class TestLottoStrategy implements LottoStrategy {
    @Override
    public List<Integer> createLottoNum() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
