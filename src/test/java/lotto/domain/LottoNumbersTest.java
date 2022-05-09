package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        this.lottoNumbers = LottoNumbers.of(Arrays.asList(6, 5, 4, 3, 2, 1));
    }

    @Nested
    class 생성자는 {

        @Nested
        class null혹은_빈값이_주어진경우 {

            @ParameterizedTest
            @NullAndEmptySource
            void IllegalArgumentException을_던진다(String nullOrEmptySource) {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new LottoNumbers(nullOrEmptySource));
            }
        }

        @Nested
        class _6개가아닌_개수가_주어진경우 {

            @Test
            void IllegalArgumentException을_던진다() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5)));
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
            }
            
        }
    }

    @Nested
    class contains_메서드는 {

        @Nested
        class 포함된_숫자가_주어질경우 {

            @Test
            void true를_리턴한다() {
                boolean actual = lottoNumbers.contains(new LottoNumber(1));

                assertThat(actual).isTrue();
            }
        }

        @Nested
        class 포함되지않은_숫자가_주어질경우 {

            @Test
            void false를_리턴한다() {
                boolean actual = lottoNumbers.contains(new LottoNumber(7));

                assertThat(actual).isFalse();
            }
        }
    }

    @Nested
    class getMatchNumberCount_메서드는 {

        @Test
        void 일치하는_번호_개수를_리턴한다() {
            LottoNumbers newLottoNumbers = LottoNumbers.of(Arrays.asList(4, 5, 6, 7, 8, 9));

            int actual = lottoNumbers.getMatchNumberCount(newLottoNumbers);

            assertThat(actual).isEqualTo(3);
        }
    }

    @Nested
    class toString_메서드는 {

        @Test
        void 번호목록_문자를_리턴한다() {
            String actual = lottoNumbers.toString();

            assertThat(actual).isEqualTo("[1, 2, 3, 4, 5, 6]");
        }
    }
}
