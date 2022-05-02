package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "로또 번호 테스트")
class LottoNumberTest {

    @Test
    void _1과_45사이의_숫자_문자열를_받아서_Wrapping_하는_객체를_생성한다() {
        assertThat(new LottoNumber("1")).isEqualTo(new LottoNumber("1"));
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @ValueSource(strings = {"0", "46"})
    void _1과_45사이의_숫자_문자열이_아니면_예외(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumber(input)
        );
    }
}