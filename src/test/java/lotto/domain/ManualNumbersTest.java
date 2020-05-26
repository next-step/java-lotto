package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualNumbersTest {

    private ManualNumbers manualNumbers;

    @BeforeEach
    void setUp() {
        List<String> manualNumbers = Arrays.asList("1, 2, 3, 4, 5, 6",
                "7, 8, 9, 10, 11, 12",
                "13, 14, 15, 16, 17, 18");

        this.manualNumbers = ManualNumbers.newInstance(manualNumbers);
    }

    @DisplayName("수동 번호가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateManualNumbersIfManualNumbersIsNull() {
        assertThatThrownBy(() -> ManualNumbers.newInstance(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 번호가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateManualNumbersIfManualNumberIsNull() {
        assertThatThrownBy(() -> {
            List<String> manualNumbers = Arrays.asList("1, 2, 3, 4, 5, 6", null);
            ManualNumbers.newInstance(manualNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 번호를 생성할 수 있다.")
    @Test
    void canCreateManualNumbers() {
        assertThat(this.manualNumbers).isInstanceOf(ManualNumbers.class);
    }

    @DisplayName("수동 번호 개수를 얻을 수 있다.")
    @Test
    void canGetCount() {
        assertThat(this.manualNumbers.getCount()).isEqualTo(3);
    }

    @DisplayName("stream 객체를 얻을 수 있다.")
    @Test
    void canGetStream() {
        assertThat(this.manualNumbers.stream()).isInstanceOf(Stream.class);
    }
}
