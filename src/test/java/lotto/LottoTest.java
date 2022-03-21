package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("중복되지 않은 6개의 로또 테스트")
    @Test
    void validLottoTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getBalls().size()).isEqualTo(6);
    }

    @DisplayName("중복되는 숫자를 가진 로또 테스트")
    @Test
    void duplicateNumberLottoTest() {
        List<Integer> numbers = Arrays.asList(1, 3, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> {
            Lotto lotto = new Lotto(numbers);
        });
    }
    
    @DisplayName("유효하지 않은 숫자를 가진 로또 테스트")
    @Test
    void invalidNumberLottoTest() {
        List<Integer> numbers = Arrays.asList(-1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> {
            Lotto lotto = new Lotto(numbers);
        });
    }
    @DisplayName("5개의 숫자를 가진 로또 테스트")
    @Test
    void invalidNumberCountLottoTest() {
        List<Integer> numbers = Arrays.asList(1, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> {
            Lotto lotto = new Lotto(numbers);
        });
    }

}