package lotto.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Nested
    class 생성자는 {

        @Nested
        class 보너스_넘버가_당첨번호에_포함될경우 {

            @Test
            void IllegalArgumentException을_던진다() {
                LottoNumbers winningLottoNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
                LottoNumber bonusBall = new LottoNumber(6);

                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusBall));
            }
        }

        @Nested
        class 보너스_넘버가_당첨번호에_포함되지_않은경우 {

            @Test
            void 에러가_발생하지_않는다() {
                LottoNumbers winningLottoNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
                LottoNumber bonusBall = new LottoNumber(7);

                assertThatCode(() -> new WinningLotto(winningLottoNumbers, bonusBall))
                        .doesNotThrowAnyException();
            }
        }
    }
}
