package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    private static final Lotto lotto1 = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
    private static final Lotto lotto2 = Lotto.from(Set.of(1, 2, 3, 4, 5, 7));
    private static final List<Lotto> lottoList = List.of(lotto1, lotto2);

    @Test
    void 로또_여러_개의_목록을_얻을_수_있다() {
        assertThat(new Lottos(lottoList).getLottoList().containsAll(lottoList)).isTrue();
    }

    @Test
    void 로또_여러_개의_갯수를_알_수_있다() {
        assertThat(new Lottos(lottoList).getLottoQuantity()).isEqualTo(2);
    }
}
