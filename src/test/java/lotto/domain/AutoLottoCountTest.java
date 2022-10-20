package lotto.domain;

import lotto.util.NullCannotBeConstructorArgException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AutoLottoCountTest {

    @DisplayName("플레이로또수와 수동로또로")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class Create {
        @DisplayName("생성한다.")
        @Test
        void of() {
            AutoLottoCount expected = new AutoLottoCount(3);
            PlayLottoCount playLottoCount = new PlayLottoCount(5);
            ManualLottoCount manualLottoCount = new ManualLottoCount(playLottoCount, 2);

            AutoLottoCount actual = AutoLottoCount.of(playLottoCount, manualLottoCount);

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("생성할때 인자값이 null 이면 예외가 발생한다.")
        @ParameterizedTest
        @MethodSource("generateNullArgs")
        void validate_size(PlayLottoCount playLottoCount, ManualLottoCount manualLottoCount) {
            assertThatThrownBy(() -> AutoLottoCount.of(playLottoCount, manualLottoCount))
                    .isExactlyInstanceOf(NullCannotBeConstructorArgException.class)
                    .hasMessage("Null은 생성자의 인자가 될 수 없습니다.");
        }

        private Stream<Arguments> generateNullArgs() {
            return Stream.of(
                    Arguments.arguments(new PlayLottoCount(4), null),
                    Arguments.arguments(null, new ManualLottoCount(new PlayLottoCount(4), 2))
            );
        }
    }
}
