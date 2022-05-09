package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {
    private LottoNumbers winningLottoNumbers;

    @BeforeEach
    void setUp() {
        this.winningLottoNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Nested
    class 생성자는 {

        @Nested
        class 보너스_넘버가_당첨번호에_포함될경우 {

            @Test
            void IllegalArgumentException을_던진다() {
                LottoNumber bonusBall = new LottoNumber(6);

                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusBall));
            }
        }

        @Nested
        class 보너스_넘버가_당첨번호에_포함되지_않은경우 {

            @Test
            void 에러가_발생하지_않는다() {
                LottoNumber bonusBall = new LottoNumber(7);

                assertThatCode(() -> new WinningLotto(winningLottoNumbers, bonusBall))
                        .doesNotThrowAnyException();
            }
        }
    }

    @Nested
    class containsBonus_메서드는 {

        @Nested
        class 보너스_넘버가_포함될경우 {

            @Test
            void true를_리턴한다() {
                LottoNumber bonusBall = new LottoNumber(7);
                LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(7, 8, 9, 10, 11, 12));

                boolean actual = new WinningLotto(winningLottoNumbers, bonusBall).containsBonus(lottoNumbers);

                assertThat(actual).isTrue();
            }
        }

        @Nested
        class 보너스_넘버가_포함되지_않을경우 {

            @Test
            void false를_리턴한다() {
                LottoNumber bonusBall = new LottoNumber(7);
                LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(8, 9, 10, 11, 12, 13));

                boolean actual = new WinningLotto(winningLottoNumbers, bonusBall).containsBonus(lottoNumbers);

                assertThat(actual).isFalse();
            }

        }
    }
}
