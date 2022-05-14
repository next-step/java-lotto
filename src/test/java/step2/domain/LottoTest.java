package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "로또 테스트")
class LottoTest {

    @Test
    void 문자열을_입력_받아서_로또_번호를_Wrapping_하는_객체를_생성() {
        Lotto lotto1 = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto1).isEqualTo(lotto2);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0}")
    @NullAndEmptySource
    void 주어진_문자열이_널이거나_빈_칸이면_예외(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(input)
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0}")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5",
            "1, 2, 3, 4, 5, 6, 7"
    })
    void 주어진_문자열의_길이가_6과_다르면_예외(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(input)
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0}")
    @ValueSource(strings = {
            "1, 1, 1, 1, 1, 1",
            "1, 2, 3, 4, 5, 5"
    })
    void 주어진_문자열에_중복이_존재하면_예외(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(input)
        );
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} -> {1} 개")
    @CsvSource(
            delimiter = ':',
            value = {
                    "1, 2, 3, 4, 5, 6:6",
                    "1, 2, 3, 4, 5, 16:5",
                    "1, 2, 3, 4, 15, 16:4",
                    "1, 2, 3, 14, 15, 16:3",
                    "1, 2, 13, 14, 15, 16:2",
                    "1, 12, 13, 14, 15, 16:1",
                    "11, 12, 13, 14, 15, 16:0"
            }
    )
    void 주어진_로또와의_맞춘_개수를_반환(String operandInput, long count) {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto operand = new Lotto(operandInput);

        assertThat(lotto.calculateHitCount(operand)).isEqualTo(count);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} -> {1}")
    @CsvSource(
            delimiter = ':',
            value = {
                    "1:true",
                    "11:false"
            }
    )
    void 주어진_로또번호를_포함하는지_반환(String input, boolean result) {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNumber number = LottoNumber.from(input);

        assertThat(lotto.contain(number)).isEqualTo(result);
    }
}