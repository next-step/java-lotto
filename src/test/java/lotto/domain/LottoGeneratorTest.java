package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.TestLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGeneratorTest {

    private static final String LOTTOS_SPLIT_SEPARATOR = "-";
    private static final String LOTTO_SPLIT_SEPARATOR = ",";
    private static final List<Integer> WIN_LOTTO_NUMBER = Arrays.asList(1,2,3,4,5,6);

    @ParameterizedTest(name = "로또갯수 입력 후 생성 시 요청 갯수만큼 로또가 만들어져야한다.")
    @CsvSource(value = {
            "1,2,3,4,8,9|1",
            "1,2,3,4,8,9-1,2,3,4,5,6|2",
            "1,2,3,7,8,9-1,2,3,4,5,6-1,2,3,4,5,7|3",
    }, delimiter = '|')
    void 로또갯수검증(String buyLottos, int lottoBuyCount) {
        Assertions.assertThat(new TestLottoGenerator(toLottos(buyLottos)).generate(lottoBuyCount)).hasSize(lottoBuyCount);
    }

    @ParameterizedTest(name = "입력한 로또번호에 당첨횟수가 winCount만큼 존재해야 한다.")
    @CsvSource(value = {
            "11,12,13,14,18,19|1|0",
            "1,2,3,14,18,19|1|1",
            "1,2,3,4,8,9-1,2,3,4,5,6|2|2",
            "11,12,13,17,18,19-11,12,13,14,15,16-11,12,13,14,15,17|3|0",
    }, delimiter = '|')
    void 로또당첨횟수검증(String buyLottos, int lottoBuyCount, int winCount) {
        Assertions.assertThat(
                new TestLottoGenerator(toLottos(buyLottos)).generate(lottoBuyCount)
                        .stream()
                        .map(lotto -> lotto.win(Lotto.buy(WIN_LOTTO_NUMBER)))
                        .filter(rank -> !rank.equals(Rank.MISS))
                        .count()
        ).isEqualTo(winCount);
    }

    private List<List<Integer>> toLottos(String lottos) {
        return Arrays.stream(lottos.split(LOTTOS_SPLIT_SEPARATOR))
                .map(lottoNumbers -> toLotto(lottoNumbers))
                .collect(Collectors.toList());
    }

    private List<Integer> toLotto(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(LOTTO_SPLIT_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}