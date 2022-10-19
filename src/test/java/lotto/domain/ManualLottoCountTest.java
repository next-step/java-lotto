package lotto.domain;

import lotto.domain.exception.CannotBeGreaterPlayableLottoCount;
import lotto.domain.exception.NotNumberStringException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ManualLottoCountTest {

    private PlayLottoCount playLottoCount;

    @BeforeEach
    void setUp() {
        playLottoCount = new PlayLottoCount(14);
    }

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("PlayLottoCount와 숫자인 문자로 생성할 수 있다.")
        @Test
        void create_string_number() {
            ManualLottoCount expected = new ManualLottoCount(playLottoCount, 3);

            ManualLottoCount actual = new ManualLottoCount(playLottoCount, 3);

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("두번째 인자 값이 플레이로또수 보다 크면 예외가 발생한다.")
        @Test
        void validate_less_than_play_lotto_count() {
            assertThatThrownBy(() -> new ManualLottoCount(playLottoCount, 15))
                    .isExactlyInstanceOf(CannotBeGreaterPlayableLottoCount.class)
                    .hasMessage("플레이 가능한 수 보다 큰 수는 입력될 수 없습니다.");
        }

        @DisplayName("숫자가 아닌 값이 입력되면 예외가 발생한다.")
        @Test
        void validate_number() {
            assertThatThrownBy(() -> new ManualLottoCount(playLottoCount, "A"))
                    .isExactlyInstanceOf(NotNumberStringException.class)
                    .hasMessage("숫자가 아닌 문자가 입력되었습니다.");
        }
    }
}
