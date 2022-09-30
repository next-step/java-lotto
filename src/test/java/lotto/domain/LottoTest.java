package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void create() {
        Lotto lotto = new Lotto(() -> List.of(3, 10, 5, 20, 43, 31));
        assertThat(lotto).isEqualTo(new Lotto(List.of(3,10,5,20,43,31)));
    }
}