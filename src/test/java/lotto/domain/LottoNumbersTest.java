package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        this.lottoNumbers = new LottoNumbers(Arrays.asList(
                new LottoNumber(3),
                new LottoNumber(2),
                new LottoNumber(1)
        ));
    }

    @Nested
    class contains_메서드는 {

        @Nested
        class 포함된_숫자가_주어질경우 {

            @Test
            void true를_리턴한다() {
                boolean actual = lottoNumbers.contains(new LottoNumber(3));

                assertThat(actual).isTrue();
            }
        }

        @Nested
        class 포함되지않은_숫자가_주어질경우 {

            @Test
            void false를_리턴한다() {
                boolean actual = lottoNumbers.contains(new LottoNumber(4));

                assertThat(actual).isFalse();
            }
        }
    }
}
