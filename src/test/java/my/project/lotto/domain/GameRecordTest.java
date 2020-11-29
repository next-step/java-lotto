package my.project.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-11-23 오후 5:40
 * Developer : Seo
 */
class GameRecordTest {
    private GameRecord record;

    @BeforeEach
    void setUp() {
        this.record = new GameRecord();
    }

    @DisplayName("인스턴스 확인")
    @Test
    void init() {
        assertThat(record)
                .isNotNull()
                .isInstanceOf(GameRecord.class);
    }

    @DisplayName("값을 저장한다")
    @ParameterizedTest
    @CsvSource(value = {"2,1"}, delimiter = ',')
    void givenNUmber_thenRecord(int input1, int input2) {
        record.add(input1);
        record.add(input2);
        assertThat(record.get()).contains(1, 2);
    }

    @DisplayName("값을 정렬한다")
    @ParameterizedTest
    @CsvSource(value = {"2,1"}, delimiter = ',')
    void givenNUmber_thenSort(int input1, int input2) {
        record.add(input1);
        record.add(input2);
        assertThat(record.get())
                .startsWith(input2)
                .endsWith(input1)
                .isSorted();
    }

    @DisplayName("0을 전달할 경우 IllegalArgumentException 예외가 발생해야 한다")
    @Test
    void givenZero_thenThrowException() {
        assertThatThrownBy(() -> record.add(0))
                .withFailMessage("0 혹은 음수가 포함되어 있습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수를 전달할 경우 IllegalArgumentException 예외가 발생해야 한다")
    @Test
    void givenNegative_thenThrowException() {
        assertThatThrownBy(() -> record.add(-1))
                .withFailMessage("0 혹은 음수가 포함되어 있습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

}