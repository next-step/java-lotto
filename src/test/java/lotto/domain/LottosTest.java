package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private static final int PURCHASE_COUNT = 3;
    private static final List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("[요구사항 1] 당첨 여부에 따라 올바른 당첨 개수가 산출되고 당첨금이 지급된다.")
    void 요구사항_1() {
        // given: shuffle하지 않고 PURCHASE_COUNT만큼 복권 만드는 전략 생성
        ForceLottoCreationStrategy forceLottoCreationStrategy = new ForceLottoCreationStrategy();

        // when: 로또 생성
        Lottos lottos = new Lottos(PURCHASE_COUNT, forceLottoCreationStrategy);

        // then: 당첨 여부 확인 (무조건 1등)
        LottoResult lottoResult = lottos.judge(lottos.getCreatedLottos(), winningLotto);

        List<Rank> ranks = lottoResult.getRanks();
        ranks.forEach(rank -> assertThat(rank.getWinningCount()).isEqualTo(Rank.FIRST_PLACE.getWinningCount()));
        ranks.forEach(rank -> assertThat(rank.getWinnings()).isEqualTo(Rank.FIRST_PLACE.getWinnings()));
    }
}
