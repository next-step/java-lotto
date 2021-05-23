package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 자동으로_로또_번호_생성_기능_테스트() {
        Lotto lotto = Lotto.createAutoLotto();
        assertThat(lotto.getLottoNumbers()).isNotNull();
        assertThat(lotto.getLottoNumbers()).isNotEmpty();
    }

    @Test
    void 중복된_로또_번호가_포함된_경우_에러_정상_발생_여부_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(5));

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 로또번호 6개가 아닙니다.");
    }

    @Test
    void 자동으로_생성된_로또_번호들의_사이즈가_6인지_여부_테스트() {
        Lotto lotto = Lotto.createAutoLotto();
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void 문자열로_이루어진_로또번호를_이용하여_로또_정상_생성_여부_확인() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(4),
                new LottoNumber(3),
                new LottoNumber(5),
                new LottoNumber(6));

        String strLottoNumbers = "1,2,3,4,5,6";
        Lotto lotto = new Lotto(strLottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    void 문자열로_이루어진_로또번호에_중복된_번호가_존재하는경우_에러_정상발생_여부_테스트() {
        String strLottoNumbers = "1,2,3,4,5,5";
        assertThatThrownBy(() -> new Lotto(strLottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자욜로_이루어진_로또번호가_6자리가_아닌경우_에러_정상_발생_여부_테스트() {
        String strLottoNumbers = "가,1,3,42,5";
        assertThatThrownBy(() -> new Lotto(strLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("숫자 ','만 입력 가능합니다.");
    }

    @Test
    void 쉼표가_아닌_구분자가_입력되었을때_에러_정상_발생_여부_테스트() {
        String strLottoNumbers = "3:1,3,42,5";
        assertThatThrownBy(() -> new Lotto(strLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("숫자 ','만 입력 가능합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:FIRST",
            "1,2,3,4,5,7:SECOND",
            "1,2,3,4,10,7:THIRD",
            "1,2,3,11,10,7:FOURTH",
            "1,2,10,11,12,14:MISS",
            "1,10,11,12,13,14:MISS",
            "7,8,9,10,11,12:MISS",
    }, delimiter = ':')
    void 당첨_결과_1등_계산_기능_테스트(String winningLottoNumbers, Rank excepted) {
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        Lotto buyLotto = new Lotto("1,2,3,4,5,6");
        Rank rank = buyLotto.calcLottoRank(winningLotto);
        assertThat(rank).isEqualTo(excepted);
    }
}
