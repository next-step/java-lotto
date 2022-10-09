package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("뒤섞인 로또 번호 불변성 확인")
    void shuffleNumbers() {
        assertThatThrownBy(() -> {
            List<Integer> shuffledLottoNumbers = LottoNumber.shuffleNumbers();
            shuffledLottoNumbers.add(5);
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
