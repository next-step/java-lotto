package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStorageTest {

    @Test
    @DisplayName("matchWithWinningLotto 메소드는 저장된 로또와 주어진 로또를 비교한 결과를 반환한다.")
    void matchWithWinningLotto() {
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6,");
        List<Lotto> lottos = List.of(
            new Lotto("2, 3, 4, 5, 6, 7"),
            new Lotto("3, 4, 5, 6, 7, 8"),
            new Lotto("4, 5, 6, 7, 8, 9"),
            new Lotto("5, 6, 7, 8, 9, 10")
        );
        LottoStoarge storage = new LottoStoarge(lottos);
        Map<Integer, Integer> result = storage.matchWithWinningLotto(winningLotto);

        assertAll(() -> {
            assertThat(result.get(2)).isEqualTo(1);
            assertThat(result.get(3)).isEqualTo(1);
            assertThat(result.get(4)).isEqualTo(1);
            assertThat(result.get(5)).isEqualTo(1);
        });
    }
}
