package lotto.domain;

import java.util.List;

public class ManualLottoStrategy implements LottoGenerateStrategy{
    private List<Lotto> manualLottos;

    public ManualLottoStrategy(List<Lotto> manualLottos) {
        this.manualLottos = manualLottos;
    }

    @Override
    public Lotto generateLotto(int count) {
        if (count > manualLottos.size()) {
            throw new IllegalArgumentException("잘못된 수동 구매 횟수를 입력하셨습니다");
        }
        return manualLottos.get(count);
    }
}
