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
    class sort_메서드는 {

        @Test
        void 정렬된_로또번호_목록을_리턴한다() {
            LottoNumbers actual = lottoNumbers.sort();

            assertThat(actual)
                    .isEqualTo(new LottoNumbers(Arrays.asList(
                            new LottoNumber(1),
                            new LottoNumber(2),
                            new LottoNumber(3)
                    )));
        }
    }
}
