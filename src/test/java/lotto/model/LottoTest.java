package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void shouldReturnLottoMatchedCount(){
        Lotto lotto = new Lotto(List.of(1, 4, 5, 6, 9));
        assertThat(lotto.getMatchedCount(new Lotto(List.of(1, 4, 5, 6, 3)))).isEqualTo(4L);
        assertThat(lotto.getMatchedCount(new Lotto(List.of(1, 4, 5, 6, 6)))).isEqualTo(4L);
    }
}