package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

    @Test
    void create() {
        assertThat(userLotto).isEqualTo(new Lotto(Arrays.asList(1,2,3,4,5,6)));
    }
}