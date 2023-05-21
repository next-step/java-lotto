package lotto.domain;

import lotto.domain.test.ForceLottoCreationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private static final int PURCHASE_COUNT = 3;

    @Test
    @DisplayName("[요구사항 1] 당첨 여부에 따라 올바른 당첨 개수가 산출되고 당첨금이 지급된다. (2등)")
    void 요구사항_1() {
        // given: 당첨 번호 생성 / shuffle하지 않고 PURCHASE_COUNT만큼 복권 만드는 전략 생성
        WinningLotto winningLotto = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 7).stream()
                                                                                       .map(LottoNumber::new)
                                                                                       .collect(Collectors.toSet())), new LottoNumber(6));
        ForceLottoCreationStrategy forceLottoCreationStrategy = new ForceLottoCreationStrategy();

        // when: 로또 생성
        Lottos lottos = new Lottos(PURCHASE_COUNT, forceLottoCreationStrategy);
        List<Lotto> createdLottos = lottos.getCreatedLottos();

        // then: 당첨 여부 확인 (무조건 2등)
        LottoResult lottoResult = lottos.judge(createdLottos, winningLotto);

        List<Rank> ranks = lottoResult.getRanks();
        ranks.forEach(rank -> assertThat(rank.getWinningCount()).isEqualTo(Rank.SECOND_PLACE.getWinningCount()));
        ranks.forEach(rank -> assertThat(rank.getWinnings()).isEqualTo(Rank.SECOND_PLACE.getWinnings()));
    }

    @Test
    @DisplayName("[요구사항 2] 당첨 여부에 따라 올바른 당첨 개수가 산출되고 당첨금이 지급된다. (3등)")
    void 요구사항_2() {
        // given: 당첨 번호 생성 / shuffle하지 않고 PURCHASE_COUNT만큼 복권 만드는 전략 생성
        WinningLotto winningLotto = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 7).stream()
                                                                                       .map(LottoNumber::new)
                                                                                       .collect(Collectors.toSet())), new LottoNumber(9));
        ForceLottoCreationStrategy forceLottoCreationStrategy = new ForceLottoCreationStrategy();

        // when: 로또 생성
        Lottos lottos = new Lottos(PURCHASE_COUNT, forceLottoCreationStrategy);
        List<Lotto> createdLottos = lottos.getCreatedLottos();

        // then: 당첨 여부 확인 (무조건 3등)
        LottoResult lottoResult = lottos.judge(createdLottos, winningLotto);

        List<Rank> ranks = lottoResult.getRanks();
        ranks.forEach(rank -> assertThat(rank.getWinningCount()).isEqualTo(Rank.THIRD_PLACE.getWinningCount()));
        ranks.forEach(rank -> assertThat(rank.getWinnings()).isEqualTo(Rank.THIRD_PLACE.getWinnings()));
    }
}
