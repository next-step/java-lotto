package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumbersTest {

        @Test
        void 로또번호_중복_제거_후_6개_아닐_시_에러() {
                assertThatThrownBy(() -> new LottoNumbers(1, 1, 2, 3, 4, 5)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("로또는 6개의 중복되지 않는 번호를 가져야 합니다.");
        }

        @Test
        void 로또번호_일급_컬렉션에_당첨번호가_있을_경우_TRUE() {
                LottoNumber oneWinningNumber = new LottoNumber(7);
                LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 7);

                assertThat(lottoNumbers.hasWinningNumber(oneWinningNumber)).isTrue();
        }

        @Test
        void 로또번호_일급_컬렉션에_보너스번호가_있을_경우_TRUE() {
                LottoNumber bonusNumber = new LottoNumber(7);
                LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 7);

                assertThat(lottoNumbers.hasBonusNumber(bonusNumber)).isTrue();
        }
}
