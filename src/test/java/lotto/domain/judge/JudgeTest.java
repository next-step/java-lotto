package lotto.domain.judge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import lotto.domain.budget.Budget;
import lotto.domain.correctnumber.CorrectNumbers;
import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {

    @DisplayName("구매한 로또 수 만큼 판별된 등수 리스트를 반환한다.")
    @Test
    void Given_정답_번호_When_등수를_판별_Then_구매한_로또_만큼_등수_리스트_반환() {

        final Lottos lottos = Lottos.createLottos(new ArrayList<>(),new Budget("14000"));
        final Judge judge = new Judge(new CorrectNumbers(
                "1,2,3,4,5,6", "7"));

        final int size = judge.getRanks(lottos.get()).get().size();

        assertThat(size).isEqualTo(14);
    }
}