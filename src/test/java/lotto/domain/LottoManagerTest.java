package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManagerTest {

    @Test
    void _0개_구매_허용X() {

        assertThatThrownBy(() ->
                new LottoManager(new ArrayList<>())
        ).isInstanceOf(IllegalArgumentException.class);

    }


}