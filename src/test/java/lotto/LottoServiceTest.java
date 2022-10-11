package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;
import lotto.service.LottoFactory;
import lotto.service.LottoService;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    public void init() {
        lottoService = new LottoService(new LottoFactory(new Calculator()));
    }

    @DisplayName("당첨 번호 확인 테스트")
    @ParameterizedTest
    @MethodSource("lottoMatchingTestCase")
    public void confirm_prize_test(List<Lotto> lottos, List<Integer> winningNumber, Prize prize) {
        Map<Integer, Integer> rankMap = lottoService.confirmLottoRank(lottos, winningNumber);
        assertThat(rankMap.get(prize.getWinningCount())).isOne();
    }

    static Stream<Arguments> lottoMatchingTestCase() {
        return Stream.of(
                arguments(Lists.list(generateLotto(Lists.list(5, 15, 23, 43, 42, 41))),
                          Lists.list(5, 15, 23, 45, 4, 2), Prize.RANK_4TH),
                arguments(Lists.list(generateLotto(Lists.list(5, 15, 23, 45, 42, 41))),
                          Lists.list(5, 15, 23, 45, 4, 2), Prize.RANK_3TH),
                arguments(Lists.list(generateLotto(Lists.list(5, 15, 23, 45, 4, 43))),
                          Lists.list(5, 15, 23, 45, 4, 2), Prize.RANK_2TH),
                arguments(Lists.list(generateLotto(Lists.list(5, 15, 23, 45, 4, 2))),
                          Lists.list(5, 15, 23, 45, 4, 2), Prize.RANK_1TH)
        );
    }

    private static Lotto generateLotto(List<Integer> lottoNum) {
        return new Lotto(lottoNum);
    }
}
