package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SplitTest {

    @DisplayName("입력된 Text 를 구분자로 잘라서 리턴한다.")
    @Test
    void fromTest() {
        String[] splitText = Split.from("1, 2, 3, 4, 5, 6", ",");

        assertThat(splitText).contains("1","2","3","4","5","6");
    }

    @DisplayName("입력된 값이 NULL 또는 empty 이면 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String text) {
        assertThatThrownBy(() -> {
            String[] splitText = Split.from(text, ",");
        }).isInstanceOf(IllegalArgumentException.class);

    }

}