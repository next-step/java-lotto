package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WinningLottoTest {

    @Test
    void 당첨_로또를_생성한다() {
        //given
        String numbers = "1, 2, 3, 4, 5, 6";
        //when
        WinningLotto winningLotto = WinningLotto.create(numbers);
        //then
        assertNotNull(winningLotto);
        assertThat(winningLotto.getLottoNumbers().stream()
                .map(Number::getStringNumber)
                .collect(Collectors.joining(", "))).isEqualTo(numbers);
    }
}
