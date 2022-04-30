package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "인덱스 테스트")
class IndexTest {

    @Test
    void 주어진_정수를_래핑하는_Index_객체를_생성() {
        assertThat(new Index(1)).isEqualTo(new Index(1));
    }

    @Test
    void _0을_래핑하는_Index_시작_객체를_생성() {
        assertThat(Index.ofStart()).isEqualTo(new Index(0));
    }

    @Test
    void 인덱스_값이_0인_경우_첫번째_숫자의_인덱스를_반환() {
        Index index = Index.ofStart();

        int firstOperandIndex = index.getFirstOperandIndex();

        assertThat(firstOperandIndex).isZero();
    }

    @Test
    void 인덱스_값이_0인_아닌_경우_첫번째_숫자의_인덱스를_호출하면_예외() {
        Index index = new Index(1);

        assertThatIllegalStateException().isThrownBy(
                index::getFirstOperandIndex
        );
    }

    @Test
    void 인덱스_값이_홀수인_경우_다음_연산자의_인덱스를_반환() {
        Index index = new Index(1);

        int result = index.getNextOperatorIndex();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 인덱스_값이_짝수인_경우_다음_연산자의_인덱스를_호출하면_예외() {
        Index index = new Index(2);

        assertThatIllegalStateException().isThrownBy(
                index::getNextOperatorIndex
        );
    }

    @Test
    void 인덱스_값이_0이_아니고_짝수인_경우_다음_숫자의_인덱스를_반환() {
        Index index = new Index(2);

        int result = index.getNextOperandIndex();

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 인덱스_값이_0인_경우_다음_숫자의_인덱스를_호출하면_예외() {
        Index index = Index.ofStart();

        assertThatIllegalStateException().isThrownBy(
                index::getNextOperandIndex
        );
    }

    @Test
    void 인덱스_값이_홀수인_경우_다음_숫자의_인덱스를_호출하면_예외() {
        Index index = new Index(1);

        assertThatIllegalStateException().isThrownBy(
                index::getNextOperandIndex
        );
    }

}