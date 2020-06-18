import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTextTest {
    @DisplayName("text를 빈 문자열 null값으로 받을 경우")
    @ParameterizedTest
    @NullAndEmptySource
    public void checkNullOrEmptyTextTest(String text) {
        assertThat(InputText.checkNullOrEmptyText(text)).isEqualTo(true);
    }
}
