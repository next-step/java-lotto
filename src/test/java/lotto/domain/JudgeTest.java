package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {

    @DisplayName("개수 확인")
    @Test
    void checkSecond() {

        // given
        final Lottos lottos = Lottos.createAutoLottos(new Budget("14000"));
        final Judge judge = new Judge(new CorrectNumbers(
            new WinningNumbers("1,2,3,4,5,6"),
            new BonusNumber("7")));

        // when
        final int size = judge.getRanks(lottos).get().size();

        // then
        assertThat(size).isEqualTo(14);
    }
}