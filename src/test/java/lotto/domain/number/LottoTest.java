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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 숫자_1_45_사이_6개의_숫자_문자열_입력시_로또_정상_생성() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto compared = new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

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
                .isThrownBy(() -> new Lotto("1, 1, 3, 4, 5, 6"))
                .withMessage(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
    }

    @Test
    void null_문자열로_로또_생성시_예외발생() {
        Assertions.assertThatNullPointerException()
                .isThrownBy(() -> new Lotto((String) null));
    }

    @Test
    void 빈문자열로_로또_생성시_예외발생() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(""))
                .withMessage(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 문자열_내_숫자가_6개_아닐때_로또_생성시_예외발생(String text) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(text))
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
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");

        assertThat(winningLotto.match(new Lotto(lotto))).isEqualTo(expected);
    }

    @Test
    void 로또번호_포함여부_확인() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        assertThat(lotto.has(new LottoNumber(1))).isTrue();
        assertThat(lotto.has(new LottoNumber(8))).isFalse();
    }

    @Test
    void 불변컬렉션_확인() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        assertThatThrownBy(() -> lotto.lottoNumbers().add(new LottoNumber(10)))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lotto.lottoNumbers().remove(new LottoNumber(2)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
