package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningNumbersTest {

        @Test
        void 당첨번호를_6개_이상_입력했을_경우_에러() {
                LottoNumber bonusNumber = new LottoNumber(10);
                assertThatThrownBy(
                    () -> new WinningNumbers(bonusNumber, 1, 2, 3, 4, 5, 6, 7)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("6개의 당첨번호를 중복되지않게 입력해주세요.");
        }

        @Test
        void 중복된_당첨번호를_입력했을_경우_에러() {
                LottoNumber bonusNumber = new LottoNumber(10);
                assertThatThrownBy(
                    () -> new WinningNumbers(bonusNumber, 1, 2, 3, 4, 6, 6)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("6개의 당첨번호를 중복되지않게 입력해주세요.");
        }

        @Test
        void 기존_입력한_당첨번호와_중복된_보너스_번호를_입력했을_경우_에러() {
                LottoNumber bonusNumber = new LottoNumber(6);
                assertThatThrownBy(
                    () -> new WinningNumbers(bonusNumber, 1, 2, 3, 4, 5, 6)).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("6개의 당첨번호와 한개의 보너스번호가 모두 중복되지않게 입력해주세요.");
        }
}
