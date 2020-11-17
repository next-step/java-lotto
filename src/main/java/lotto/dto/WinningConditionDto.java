package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.LottoNoPool;
import lotto.domain.WinningCondition;

import java.util.List;

public class WinningConditionDto {

    private final WinningCondition winningCondition;

    // FIXME: builder 의 멤버가 비었을 때 발생하는 NPE 는 어디서 어떻게 처리해야하는가?
    // FIXME: 혹은 builder 패턴에서 필수값을 강제하려면 어떻게 해야하는가?
    private WinningConditionDto(Builder builder) {
        Lotto winningLotto = new Lotto(builder.winningLotto);
        LottoNo bonus = LottoNoPool.getLottoNo(builder.bonus);
        winningCondition = new WinningCondition(winningLotto, bonus);
    }


    public WinningCondition toEntity() {
        return winningCondition;
    }

    public static class Builder {
        private List<Integer> winningLotto;
        private Integer bonus;


        public Builder winningLotto(List<Integer> val) {
            winningLotto = val;
            return this;
        }

        public Builder bonus(int val) {
            bonus = val;
            return this;
        }

        public WinningConditionDto build() {
            return new WinningConditionDto(this);
        }
    }
}
