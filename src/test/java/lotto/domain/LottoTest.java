package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.list;

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

    @Test
    void fifth_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        lotto.checkWinning(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.isFifthWinner()).isTrue();
    }

    @Test
    void fourth_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        lotto.checkWinning(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.isFourthWinner()).isTrue();
    }

    @Test
    void third_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        lotto.checkWinning(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.isThirdWinner()).isTrue();
    }

    @Test
    void first_winner() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.checkWinning(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.isFirstWinner()).isTrue();
    }
}