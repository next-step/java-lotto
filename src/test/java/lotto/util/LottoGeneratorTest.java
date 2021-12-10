package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또를 생성하기 위한 유틸 `LottoGenerator`에 대한 테스트")
class LottoGeneratorTest {

    @DisplayName("`Lotto` 생성을 위한 무작위 번호 6자리 생성")
    @Test
    void generateRandomNumbersTest() {
        // given
        int totalSizeOfNumbers = 6;
        // when
        List<Integer> randomNumbers = LottoGenerator.generateSortedNumbers(totalSizeOfNumbers);
        // then
        assertThat(randomNumbers.size()).isEqualTo(totalSizeOfNumbers);
    }
}
