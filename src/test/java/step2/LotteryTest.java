package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Lottery;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class LotteryTest {

    @Test
    @DisplayName("자동으로 생성된 로또 번호 range가 1이상 45이하인지 테스트")
    void is_between_1_to_45() {
        Lottery lottery = new Lottery();
        assertThat(
                lottery.getSelectedNumbers()
                        .stream()
                        .allMatch(number -> number >= 1 && number <= 45)
        ).isEqualTo(true);
    }
}