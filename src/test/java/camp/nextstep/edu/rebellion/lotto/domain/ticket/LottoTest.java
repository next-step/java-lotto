package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @DisplayName("입력된 번호와 로또 번호가 잘 일치 되는지 확인")
    @Test
    public void matchTest() {
        // given
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);

        // when
        assertAll(
                () -> assertThat(lotto.match(1)).isTrue(),
                () -> assertThat(lotto.match(4)).isTrue(),
                () -> assertThat(lotto.match(7)).isFalse()
        );
    }
}
