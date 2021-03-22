package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "6:6",
            "5:5",
            "14:14"}, delimiter = ':')
    @DisplayName("랜덤 번호들을 정해진 범위내에서 뽑을 수 있다")
    void godChoosesExpectedNumbers(int upperbound, int count) {
        List<Integer> issuedNumbers = LottoNumberGenerator.issueNumbers(upperbound, count);
        issuedNumbers.forEach((value) -> assertThat(value <= count).isTrue());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6:6:6",
            "15:5:5",
            "45:14:14"}, delimiter = ':')
    @DisplayName("랜덤 번호들을 정해진 숫자만큼 뽑을 수 있다")
    void godChoosesExpectedSizeOfNumbers(int upperbound, int count, int expected) {
        List<Integer> issuedNumbers = LottoNumberGenerator.issueNumbers(upperbound, count);
        assertThat(issuedNumbers.size()).isEqualTo((expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6:7",
            "5:7",
            "14:100"}, delimiter = ':')
    @DisplayName("뽑아야 하는 번호의 수가 뽑을 수 있는 번호의 수보다 크면 IllegalArgumentException을 던진다")
    void godThrowsExceptionOnInvalidNumberCounts(int upperbound, int count) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoNumberGenerator.issueNumbers(upperbound, count));
    }

}
