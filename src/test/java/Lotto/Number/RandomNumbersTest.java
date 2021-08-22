package Lotto.Number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 넘버 리스트는")
public class RandomNumbersTest {

    @DisplayName("랜덤 숫자를 주어진 갯수만큼 만든다.")
    @ParameterizedTest(name = "갯수: {0}")
    @ValueSource(ints = {5, 6, 7})
    void generateGivenLengthOfNumbers(int length) {
        int actual = new RandomNumbers(length, Limit.MIN.getValue(), Limit.MAX.getValue()).getValue().size();
        int expected = length;
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("랜덤 넘버 후보의 최댓값 = 생성자에 명시된 최댓값")
    @Test
    void generateGivenMaxAsMaxCandidateOfRandomNumbers() {
        RandomNumbers randomNumbers = new RandomNumbers(Limit.MAX.getValue(), Limit.MIN.getValue(), Limit.MAX.getValue());
        LottoNumber actual = randomNumbers.getValue().stream().max(Comparator.comparing(LottoNumber::getValue)).get();
        LottoNumber expected = new LottoNumber(Limit.MAX.getValue());
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("랜덤 넘버 후보의 최솟값 = 생성자에 명시된 최솟값")
    @Test
    void generateGivenMinAsMinCandidateOfRandomNumbers() {
        RandomNumbers randomNumbers = new RandomNumbers(Limit.MAX.getValue(), Limit.MIN.getValue(), Limit.MAX.getValue());
        LottoNumber actual = randomNumbers.getValue().stream().min(Comparator.comparing(LottoNumber::getValue)).get();
        LottoNumber expected = new LottoNumber(Limit.MIN.getValue());
        assertThat(actual).isEqualTo(expected);
    }
}
