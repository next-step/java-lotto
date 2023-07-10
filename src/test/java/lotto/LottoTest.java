package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTest {

    @Test
    void 로또_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Lotto(null));
    }
    
    @Test
    void 로또_객체_생성시_번호_생성() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        
        // when & then
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }
}
