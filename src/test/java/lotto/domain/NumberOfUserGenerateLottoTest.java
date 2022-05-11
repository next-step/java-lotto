package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberOfUserGenerateLottoTest {
    private UserAmount userAmount;

    @BeforeEach
    void setUp() {
        this.userAmount = new UserAmount(10000);
    }

    @Nested
    class 생성자는 {

        @Nested
        class 음수가_주어질경우 {

            @ParameterizedTest
            @ValueSource(ints = {-1})
            void IllegalArgumentException을_던진다(int aInt) {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new NumberOfUserGenerateLotto(aInt, userAmount));
            }
        }

        @Nested
        class 살수있는_개수보다_많은값이_주어지면 {

            @ParameterizedTest
            @ValueSource(ints = {11})
            void IllegalArgumentException을_던진다(int aInt) {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new NumberOfUserGenerateLotto(aInt, userAmount));
            }
        }

        @Nested
        class 살수있는_개수만큼의_값이_주어지면 {

            @ParameterizedTest
            @ValueSource(ints = {0, 10})
            void 에러가_발생하지_않는다(int aInt) {
                assertThatCode(() -> new NumberOfUserGenerateLotto(aInt, userAmount))
                        .doesNotThrowAnyException();
            }
        }
    }
}
