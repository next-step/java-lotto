package lotto.domain.number;

import lotto.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 문자열_변환_로또_생성() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        Lotto compared = new Lotto(List.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));

        assertThat(lotto.match(compared)).isEqualTo(6);
    }

    @Test
    @DisplayName("무작위 번호로 로또 번호 6개가 정상적으로 생성되었는지 확인한다. 무작위가 아니면 1,2,3,4,5,6로 생성됨")
    void 무작위_번호_로또_생성() {
        Lotto lotto = Lotto.create();
        Lotto compared = new Lotto(List.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));

        assertThat(lotto.match(compared)).isNotEqualTo(6);
    }

    @Test
    void 로또_생성_중복숫자() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of("1, 1, 3, 4, 5, 6"))
                .withMessage(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 47", "0, 1, 2, 3, 4, 5", "1, 3, 2, -3, 4, 5"})
    void 로또_생성_문자열_1_45_아님(String text) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(text))
                .withMessage(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
    }

    @Test
    void 로또_생성_문자열_null() {
        Assertions.assertThatNullPointerException()
                .isThrownBy(() -> Lotto.of(null));
    }

    @Test
    void 로또_생성_문자열_빈문자() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(""))
                .withMessage(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 로또_생성_문자열_6개_아님(String text) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(text))
                .withMessage(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,6,7:5",
            "1,2,3,4,7,8:4",
            "2,5,1,22,10,20:3",
            "10,2,12,4,16,21:2",
            "6,11,45,40,20,30:1",
            "21,22,23,24,25,26:0"
    }, delimiter = ':')
    void 로또_일치_여부(String lotto, int expected) {
        Lotto winningLotto = Lotto.of("1,2,3,4,5,6");

        assertThat(winningLotto.match(Lotto.of(lotto))).isEqualTo(expected);
    }
}
