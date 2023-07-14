package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("WinningLotto 클래스")
class WinningLottoTest {

    private static final int BONUS_NUMBER = 7;
    private final Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5, 6);

    @Nested
    @DisplayName("new 생성자는")
    class Describe_New_Constructor {

        @Nested
        @DisplayName("lotto 번호들과, bonus 번호를 받으면,")
        class Context_Input_Bonus_And_Lotto_Numbers {

            @Test
            @DisplayName("생성한다.")
            void It_Create() {
                assertThatCode(() -> new WinningLotto(lottoNumbers, BONUS_NUMBER)).doesNotThrowAnyException();
            }
        }
    }
}
