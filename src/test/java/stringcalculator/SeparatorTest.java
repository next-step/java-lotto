package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.Separator;

class SeparatorTest {

    @DisplayName("사용자 입력으로 들어온 문자열에서 콤마(,),콜론(:)을 제거")
    @ParameterizedTest
    @ValueSource(strings = {"//.\n123,456:789.10", "//@\n123,456:789@10", "//$\n123,456:789$10"})
    void 사용자_입력으로_들어온_문자열에서_콤마_콜론_을_기준으로_자름(final String userInput) {
        Separator separator = new Separator(userInput);
        assertThat(separator.split())
            .isEqualTo(Arrays.asList("123", "456", "789", "10"));
    }
}
