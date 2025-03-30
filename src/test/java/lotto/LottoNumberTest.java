package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 1에서 45 사이여야 한다. ")
    void validateNumber(){
        int invalidNumber = 0;
        assertThatThrownBy(() -> LottoNumber.of(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1에서 45 사이여야 합니다.");
    }
    @Test
    @DisplayName("셔플된 번호 리스트의 크기는 45개이다.")
    void testShuffledNumbersSize() {
        List<LottoNumber> shuffledNumbers = LottoNumber.getShuffledNumbers();
        assertEquals(45, shuffledNumbers.size(), "셔플된 번호 리스트는 45개의 숫자를 포함해야 합니다.");
    }

}
