package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoStorage;
import lotto.domain.WinningInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStorageTest {

    @Test
    @DisplayName("matchAllWithWinningLotto 메소드는 저장된 로또와 주어진 로또를 비교한 결과를 반환한다.")
    void matchAllWithWinningLotto() {
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = List.of(
            new Lotto("2, 3, 4, 5, 6, 7"),
            new Lotto("3, 4, 5, 6, 7, 8"),
            new Lotto("4, 5, 6, 7, 8, 9"),
            new Lotto("5, 6, 7, 8, 9, 10")
        );
        LottoStorage storage = new LottoStorage(lottos);
        storage.matchAllWithWinningLotto(winningLotto);
        Map<WinningInformation, Long> result = storage.getResult();

        assertAll(() -> {
            assertThat(result.get(WinningInformation.FOURTH)).isEqualTo(1);
            assertThat(result.get(WinningInformation.THIRD)).isEqualTo(1);
            assertThat(result.get(WinningInformation.SECOND)).isEqualTo(1);
        });
    }

    @Test
    @DisplayName("getProfit 메소드는 수익률을 반환한다.")
    void getProfit() {
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = List.of(
            new Lotto("2, 3, 4, 5, 6, 7"),
            new Lotto("3, 4, 5, 6, 7, 8"),
            new Lotto("4, 5, 6, 7, 8, 9"),
            new Lotto("5, 6, 7, 8, 9, 10")
        );
        LottoStorage storage = new LottoStorage(lottos);
        storage.matchAllWithWinningLotto(winningLotto);

        assertThat(storage.getProfit()).isEqualTo(1_555_000 / 4_000);
    }
}
