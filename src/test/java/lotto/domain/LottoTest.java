package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_개수_구하기() {
        Lottos lottos = Lottos.of(14000, new RandomLottoGenerator());
        assertThat(lottos.getLottos().size()).isEqualTo(14);
    }

    @Test
    void 로또_생성() {
        Lottos lottos = Lottos.of(14000, () -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottos.getLottos().get(0)).isEqualTo(Lotto.createLotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void 로또_번호_비교() {
        Lotto lotto = Lotto.createLotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        assertThat(lotto.findSameNumber(winningNumbers)).isEqualTo(6);
    }

    @Test
    void 당첨_개수_가져오기() {
        Lottos lottos = Lottos.of(14000, () -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(new String[]{"1", "2", "3"});
        assertThat(lottos.getWinningCount(winningNumbers).get((long)3)).isEqualTo(14);
    }

}
