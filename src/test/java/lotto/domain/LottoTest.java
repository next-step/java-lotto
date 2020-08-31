package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 랭크_가져오기() {
        // 사전 데이터 준비
        Lottos lottos = Lottos.of(14000, () -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(new String[]{"1", "2", "3"});
        BonusNumber bonusNumber = new BonusNumber(1);

        // 테스트 자료 조작
        List<Rank> actual = lottos.getRanks(winningNumbers, bonusNumber);

        // 조작 결과 올바른지 확인
        assertThat(actual.get(0)).isEqualTo(FIFTH);
    }

    @Test
    void Enum_활용해서_랭크_등수_GET() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(FIFTH);
        assertThat(Rank.valueOf(5, true)).isEqualTo(SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(THIRD);
        assertThatThrownBy(() -> Rank.valueOf(8, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("일치하는 등수가 없습니다.");
    }

    @Test
    void 보너스_숫자_처리() {
        Lotto lotto = Lotto.createLotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        BonusNumber bonusNumber = new BonusNumber(1);
        boolean isMatch = bonusNumber.getBonusMatch(lotto.getLotto());

        assertThat(isMatch).isEqualTo(true);
    }

    @Test
    void RanksCount() {
        Lottos lottos = Lottos.of(14000, () -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        WinningNumbers winningNumbers = new WinningNumbers(new String[]{"1", "2", "3", "4", "5"});
        BonusNumber bonusNumber = new BonusNumber(1);

        Ranks ranks = new Ranks(lottos.getRanks(winningNumbers, bonusNumber));
        assertThat(ranks.getRanksCount().get(1)).isEqualTo(14L);
    }
}
