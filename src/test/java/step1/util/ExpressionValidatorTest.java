package step1.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExpressionValidatorTest {

    @Test
    public void 문자열이_null_이면_에외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validate(null);
        });
    }

    @Test
    public void 문자열이_비어있으면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validate("");
        });
    }

    @Test
    public void 문자열이_공백으로만_이루어져_있으면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validate("   ");
        });
    }
}
