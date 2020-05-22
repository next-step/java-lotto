package lotto.domain.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    private List<LottoNumber> randomNumbers;

    @BeforeEach
    void setUp() {
        randomNumbers = LottoNumbersGenerator.generate();
    }

    @DisplayName("1 ~ 45 사이의 6개의 숫자를 랜덤으로 생성")
    @Test
    void generate() {
        assertThat(randomNumbers.size()).isEqualTo(LottoNumbers.LOTTO_NUMBER_SIZE);
    }

    @DisplayName("랜덤으로 생성한 숫자는 1 ~ 45 사이의 값")
    @Test
    void range() {
        assertThat(randomNumbers.stream()
                .anyMatch(randomNumber ->
                        (randomNumber.getNumber() < LottoNumber.MIN_VALUE) || (randomNumber.getNumber() > LottoNumber.MAX_VALUE)))
                .isFalse();
    }

    @DisplayName("랜덤으로 생성한 숫자는 중복되지 않음")
    @Test
    void notDuplicate() {
        assertThat(randomNumbers.size()).isEqualTo(new HashSet<>(randomNumbers).size());
    }
}
