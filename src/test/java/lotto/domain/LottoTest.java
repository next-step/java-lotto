package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 당첨번호와_로또번호의_일치_개수_총합() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.sumMatchCount(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)))).isEqualTo(6);
    }
}
