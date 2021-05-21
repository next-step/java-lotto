package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkedLottoNumbersTest {

    @DisplayName("자동 마킹된 번호는 1~45 사이의 6개 번호이다")
    @Test
    void markedLottoNumbersTest() {
        //given
        MarkedLottoNumbers markedLottoNumbers = new MarkedLottoNumbers();
        List<Integer> markedNumbers = markedLottoNumbers.lottoNumbers();

        //then
        assertThat(markedNumbers.size()).isEqualTo(6);
        Set<Integer> numberSet = new HashSet<>();
        for (Integer lottoNumber : markedNumbers) {
            assertThat(lottoNumber).isBetween(1,45);
            numberSet.add(lottoNumber);
        }
        assertThat(numberSet.size()).isEqualTo(6);
    }
}
