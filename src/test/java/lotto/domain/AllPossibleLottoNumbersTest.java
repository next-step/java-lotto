package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AllPossibleLottoNumbersTest {

    @Test
    @DisplayName("생성가능한 모든 로또 숫자들중에서 6개의 숫자를 무작위로 뽑아낼 수 있다.")
    void drawRandomSixNumbers() {
        int expectedNumberSize = 6;
        AllPossibleLottoNumbers allNumbers = AllPossibleLottoNumbers.getInstance();
        List<LottoNumber> sixNumbers = allNumbers.drawRandomSixNumbers();

        assertThat(sixNumbers.size()).isEqualTo(expectedNumberSize);
    }
}