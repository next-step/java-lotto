package lotto.domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.number.LottoNumber;
import lotto.domain.user.UserLotto;
import lotto.domain.winning.WinningBalls;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    private LottoResults lottoResults;
    private WinningBalls winningBalls;
    private List<UserLotto> userLottos = new ArrayList<>();

    @Test
    void 당첨_심사_테스트_일반당첨() {
        String[] numbers = {"1", "2", "3", "4", "40", "41"};
        List<Integer> candidates = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumber> lottoNumbers = candidates.stream().map(LottoNumber::new)
            .collect(Collectors.toList());

        winningBalls = new WinningBalls(numbers, "45");
        userLottos.add(new UserLotto(lottoNumbers));

        lottoResults = new LottoResults(userLottos, winningBalls);
        assertThat(lottoResults.getRawLottoResults().get(0)).isEqualTo(LottoResult.FOUR_MATCHING);
    }
}
