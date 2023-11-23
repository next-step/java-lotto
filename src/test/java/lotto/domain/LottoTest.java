package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 생성() {
        Lotto lotto = new Lotto();
        assertThat(lotto.lotto()).hasSize(6);
    }

    @Test
    void 정렬() {
        Lotto lotto = new Lotto();
        assertThat(lotto.lotto()).isSorted();
    }
}