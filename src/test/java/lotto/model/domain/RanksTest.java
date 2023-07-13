package lotto.model.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RanksTest {

    @Test
    void Ranks_객체_생성_성공() {
        assertThatNoException().isThrownBy(() -> Ranks.of(List.of()));
    }
}
