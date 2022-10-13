package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Prize;
import lotto.domain.WinningNumber;

class WinningNumberTest {
    @DisplayName("당첨 번호 확인 테스트")
    @ParameterizedTest
    @MethodSource("lottoMatchingTestCase")
    public void confirm_prize_test(Lotto lotto, List<Integer> winningNumbers, Prize prize) {
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        Map<Prize, Integer> rankMap = winningNumber.calcLottoRank(lotto);
        assertThat(rankMap.get(prize)).isOne();
    }

    static Stream<Arguments> lottoMatchingTestCase() {
        return Stream.of(
                arguments(generateLotto(Lists.list(1, 2, 3, 43, 42, 41)),
                         Lists.list(5, 15, 23, 45, 4, 2), Prize.NO_RANK),
                arguments(generateLotto(Lists.list(5, 15, 23, 43, 42, 41)),
                          Lists.list(5, 15, 23, 45, 4, 2), Prize.RANK_4TH),
                arguments(generateLotto(Lists.list(5, 15, 23, 43, 42, 41)),
                          Lists.list(5, 15, 23, 45, 4, 2), Prize.RANK_4TH),
                arguments(generateLotto(Lists.list(5, 15, 23, 45, 42, 41)),
                          Lists.list(5, 15, 23, 45, 4, 2), Prize.RANK_3TH),
                arguments(generateLotto(Lists.list(5, 15, 23, 45, 4, 43)),
                          Lists.list(5, 15, 23, 45, 4, 2), Prize.RANK_2TH),
                arguments(generateLotto(Lists.list(5, 15, 23, 45, 4, 2)),
                          Lists.list(5, 15, 23, 45, 4, 2), Prize.RANK_1TH)
        );
    }

    private static Lotto generateLotto(List<Integer> lottoNum) {
        return new Lotto(Lists.list(new LottoNumber(lottoNum)));
    }
}
