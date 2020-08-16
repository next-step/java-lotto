package lotto.ui;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoUserInputTest {
    @DisplayName("사용자가 등록한 순서에 맞게 Set자료형으로 Lotto 번호 반환")
    @Test
    void stringArrayToIntSetTest() {
        String[] inputLottos = {"4", "2", "1", "7", "3", "5"};
        Set<Integer> lottos = LottoUserInput.stringArrayToIntSet(inputLottos);
        assertThat(lottos).containsExactly(4, 2, 1, 7, 3, 5);
    }
}