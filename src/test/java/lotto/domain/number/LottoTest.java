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
    void 숫자_1_45_사이_6개의_숫자_문자열_입력시_로또_정상_생성() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        Lotto compared = new Lotto(List.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));

        assertThat(lotto.equals(compared)).isTrue();
    }

    @Test
    @DisplayName("무작위 번호로 로또 번호 6개가 정상적으로 생성되었는지 확인한다. 무작위가 아니면 1,2,3,4,5,6로 생성됨")
    void 무작위_번호_발생_로직을_사용한_자동번호_로또_정상_생성() {
        Lotto lotto = Lotto.create();
        Lotto compared = Lotto.create();

        assertThat(lotto.equals(compared)).isFalse();
    }

    @Test
    void 중복숫자_입력이_있는_문자열로_로또_생성시_예외발생() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of("1, 1, 3, 4, 5, 6"))
                .withMessage(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
    }

    @Test
    void null_문자열로_로또_생성시_예외발생() {
        Assertions.assertThatNullPointerException()
                .isThrownBy(() -> Lotto.of(null));
    }

    @Test
    void 빈문자열로_로또_생성시_예외발생() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(""))
                .withMessage(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 문자열_내_숫자가_6개_아닐때_로또_생성시_예외발생(String text) {
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
    void 로또끼리_비교하여_일치하는_숫자_개수_정상_반환(String lotto, int expected) {
        Lotto winningLotto = Lotto.of("1,2,3,4,5,6");

        assertThat(winningLotto.match(Lotto.of(lotto))).isEqualTo(expected);
    }
}
