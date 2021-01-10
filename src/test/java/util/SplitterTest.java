package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SplitterTest {

    @Test
    @DisplayName("번호 자르기")
    void createWinnerNumbers() {
        assertThat(Splitter.SplitStringNumbers("1,2,3,4,5,6").size()).isEqualTo(6);
    }

    @Test
    @DisplayName("번호 입력 값 길이를 검사")
    void validateInputNumberLength() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Splitter.SplitStringNumbers("1,2,3,4,5,6,7");
        });
    }
}