package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_개수_구하기() {
        // 사전 데이터 준비
        Lottos lottos = Lottos.of(14000, new RandomLottoGenerator());

        // 테스트 확인
        assertThat(lottos.getLottos().size()).isEqualTo(14);
    }

    @Test
    void 로또_생성() {
        // 사전 데이터 준비
        Lottos lottos = Lottos.of(14000, () -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // 테스트 확인
        assertThat(lottos.getLottos().get(0)).isEqualTo(Lotto.createLotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void 로또_직접_생성() {
        // 사전 데이터 준비
        Lottos lottos = Lottos.of("1 2 3 4 5 6");

        // 테스트 확인
        assertThat(lottos.getLottos().get(0)).isEqualTo(Lotto.createLotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void 로또_번호_비교() {
        // 사전 데이터 준비
        Lotto lotto = Lotto.createLotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});

        // 테스트 자료 조작
        long actual = lotto.getWinningCount(winningNumbers);

        // 조작 결과 올바른지 확인
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 당첨_개수_가져오기() {
        // 사전 데이터 준비
        Lottos lottos = Lottos.of(14000, () -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(new String[]{"1", "2", "3"});

        // 테스트 자료 조작
        long actual = lottos.getWinningCounts(winningNumbers).get((long) 3);

        // 조작 결과 올바른지 확인
        assertThat(actual).isEqualTo(14);
    }

}
