package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "지난 당첨 번호 테스트")
class WinnerTest {

    @Test
    void 문자열과_보너스_번호를_입력_받아서_컴마로_구분하여_지난_당첨_번호_객체를_생성() {

        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", "7");
        WinningLotto winningLotto2 = new WinningLotto("1, 2, 3, 4, 5, 6", "7");

        assertThat(winningLotto).isEqualTo(winningLotto2);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @NullAndEmptySource
    void 주어진_문자열이_널이거나_공백으로만_이루어져있으면_예외(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningLotto(input, "7")
        );
    }

    @Test
    void 주어진_문자열의_컴마로_구분된_번호_갯수가_각_회차에_할당된_당첨번호_수와_다르면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningLotto("1, 2", "7")
        );
    }

    @Test
    void 주어진_문자열의_컴마로_구분된_번호에_중복이_존재하면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningLotto("1, 1, 2, 3, 4, 5", "7")
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @NullAndEmptySource
    void 주어진_보너스_번호가_널이거나_공백이면_예외(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningLotto("1, 2, 3, 4, 5, 6", input)
        );
    }

    @Test
    void 주어진_보너스_번호가_지난_당첨_번호와_중복되면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningLotto("1, 2, 3, 4, 5, 6", "6")
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @CsvSource(
            delimiter = ':',
            value = {
                    "1:true",
                    "7:false",
                    "45:false"
            }
    )
    void 주어진_로또_번호가_지난_당첨_번호에_포함되는지_반환(String input, boolean expect) {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", "7");
        LottoNumber lottoNumber = LottoNumber.from(input);

        boolean result = winningLotto.isContain(lottoNumber);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @CsvSource(
            delimiter = ':',
            value = {
                    "7:true",
                    "45:false"
            }
    )
    void 주어진_로또_번호가_보너스번호인지_반환(String input, boolean expect) {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", "7");
        LottoNumber bonusNumber = LottoNumber.from(input);

        boolean result = winningLotto.isBonusNumber(bonusNumber);

        assertThat(result).isEqualTo(expect);
    }
}