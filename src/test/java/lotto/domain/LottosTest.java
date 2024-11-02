package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    void _0개_구매_허용X() {

        assertThatThrownBy(() ->
                new Lottos(new ArrayList<>())
        ).isInstanceOf(IllegalArgumentException.class);

    }


}