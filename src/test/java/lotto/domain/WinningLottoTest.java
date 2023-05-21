package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {

    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toSet())), new LottoNumber(9));
    }

    @Test
    @DisplayName("[요구사항 1] 당첨 번호 6개와 모두 일치하는 복권을 사면 1등이다.")
    void 요구사항_1() {
        // given: 기대 되는 결과
        Rank expectedRank = Rank.FIRST_PLACE;

        // when: 로또 구입
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toSet()));

        // then
        assertThat(winningLotto.calculateRank(lotto)).isEqualTo(expectedRank);
    }

    @Test
    @DisplayName("[요구사항 2] 당첨 번호와 동일한 번호들을 가진 로또를 구입했을 때 일치되는 숫자는 6개이다.")
    void 요구사항_2() {
        // given: 기대 되는 결과
        int expectedMatchCount = 6;

        // when: 복권 당첨 번호와 같은 번호들을 가진 로또 구입
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toSet()));

        // then
        assertThat(winningLotto.getMatchNumbers(lotto)).isEqualTo(expectedMatchCount);
    }
}