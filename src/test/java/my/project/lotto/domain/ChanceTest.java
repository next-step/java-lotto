package my.project.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ChanceTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(ints = {1000})
    void testConstruct(int param) {
        assertThat(new Chance(param))
                .isNotNull()
                .isInstanceOf(Chance.class);
    }

    @DisplayName("금액 미만 시 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {999})
    void testFailConstruct(int param) {
        assertThatThrownBy(() -> new Chance(param))
                .hasMessage("구입금액은 1000원 이상입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("티켓 구하기")
    @ParameterizedTest
    @ValueSource(ints = {1000})
    void testGetTicket(int param) {
        assertThat(new Chance(param).getChances()).isEqualTo(1);
    }

}