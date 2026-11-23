import domain.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {


    @Test
    void 문자열을_콤마로_분리해_당첨_번호를_생성한다() {
        assertThat(new WinningNumber("1, 2, 3, 4, 5, 6"))
                .isEqualTo(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)));
    }


    @ParameterizedTest
    @ValueSource(strings = {"4, ,5,6,7,8", "", "1,2,3,4,5,", "1,,2,3,4,5"})
    void 콤마_사이가_비어있거나_공백이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"?,/,1,3,4", "1,2,삼,4,5,6", "1.5,2,3,4,5,6"})
    void 콤마_사이가_숫자가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,6", "1,2,3,4,5,46"})
    void 번호가_1부터_45사이가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,1,2,3,4,5"})
    void 번호가_6개가_아니거나_중복이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 콤마와_숫자_사이의_공백은_제거된다() {
        assertThat(new WinningNumber(" 1 ,2,  3 ,4,5,6"))
                .isEqualTo(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)));
    }
}
