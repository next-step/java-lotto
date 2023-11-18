package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    private LottoNumber lottoNumber;

    void createTest(int number) {
        lottoNumber = new LottoNumber(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또_번호_유효성_검사_성공(int number) {
        // given
        createTest(number);
        // when
        int lottoNumber = this.lottoNumber.number();
        // then
        assertThat(lottoNumber).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, 48, 49, 50})
    void 로또_번호_유효성_검사_실패(int number) {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            createTest(number);
        });
    }

    @DisplayName("로또 번호 비교")
    @Nested
    class 로또_번호_비교 {

        @Test
        void 로또_번호_비교_큰_숫자() {
            // given
            createTest(1);
            LottoNumber lottoNumber2 = new LottoNumber(2);
            // when
            int result = lottoNumber.compareTo(lottoNumber2);
            // then
            assertThat(result).isEqualTo(-1);
        }

        @Test
        void 로또_번호_비교_같은_숫자() {
            // given
            createTest(1);
            LottoNumber lottoNumber2 = new LottoNumber(1);
            // when
            int result = lottoNumber.compareTo(lottoNumber2);
            // then
            assertThat(result).isEqualTo(0);
        }

        @Test
        void 로또_번호_비교_작은_숫자() {
            // given
            createTest(2);
            LottoNumber lottoNumber2 = new LottoNumber(1);
            // when
            int result = lottoNumber.compareTo(lottoNumber2);
            // then
            assertThat(result).isEqualTo(1);
        }

        @Test
        public void 로또_번호_6개_보너스_추가_유효성_검사_중복번호_입력() {
            // given
            Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
            LottoNumber bonusNumber = new LottoNumber(6);
            // when
            assertThatIllegalArgumentException().isThrownBy(() -> bonusNumber.checkBonusNumber(lotto, bonusNumber));
            // then
        }
    }
}
