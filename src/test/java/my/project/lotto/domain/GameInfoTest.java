package my.project.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameInfoTest {
    private GameInfo info;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("인스턴스 확인")
    @ParameterizedTest
    @ValueSource(ints = {14000})
    void init(int input) {
        this.info = new GameInfo(input);
        assertThat(info)
                .isNotNull()
                .isInstanceOf(GameInfo.class);
    }

    @DisplayName("금액을 입력받고 회수를 저장한다")
    @ParameterizedTest
    @ValueSource(ints = {14000})
    void givenNUmber_thenRecord(int input) {
        this.info = new GameInfo(input);
        assertThat(info.getCount()).isEqualTo(14);
    }

    @DisplayName("0을 전달할 경우 IllegalArgumentException 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0})
    void givenZero_thenThrowException(int input) {
        assertThatThrownBy(() -> new GameInfo(input))
                .withFailMessage("구입금액은 1000원 이상입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수를 전달할 경우 IllegalArgumentException 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void givenNegative_thenThrowException(int input) {
        assertThatThrownBy(() -> new GameInfo(input))
                .withFailMessage("구입금액은 1000원 이상입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

}