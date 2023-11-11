package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerResultTest {

    private WinnerResult winnerResult;

    public void setUp(Map<RankLotto, Integer> result) {
        winnerResult = new WinnerResult(result);
    }

    @DisplayName("당첨3개 5000원, 3개")
    @Test
    void 당첨_5000원() {
        //given
        setUp(Map.of(RankLotto.FOURTH, 3));
        //when
        Map<RankLotto, Integer> result = winnerResult.result();
        //then
        assertThat(result.get(RankLotto.FOURTH)).isEqualTo(3);
    }

    @DisplayName("당첨 총액 수익률")
    @Test
    void 당첨_수익률() {
        //given
        setUp(Map.of(RankLotto.FIRST, 0, RankLotto.SECOND, 0, RankLotto.THIRD, 0, RankLotto.FOURTH, 1, RankLotto.MISS, 0));
        //when
        double result = winnerResult.rateOfReturn(10000);
        //then
        assertThat(result).isEqualTo(0.5);
    }

    @DisplayName("당첨 결과 출력 문구")
    @Test
    void 당첨_결과_출력문구() {
        //given
        setUp(Map.of(RankLotto.FOURTH, 3));
        //when
        String result = winnerResult.toString();
        //then
        assertThat(result).isEqualTo("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원) - 3개");
    }

    @DisplayName("당첨 갯수 체크 후 생성")
    @Test
    void 당첨_갯수_체크() {
        //given
        Lotto winLotto = createLotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(createLotto(List.of(10, 20, 30, 4, 5, 6)), createLotto(List.of(1, 20, 30, 40, 5, 6)));
        //when
        winnerResult = new WinnerResult(winLotto, lottos);
        //then
        assertThat(winnerResult.result().get(RankLotto.FOURTH)).isEqualTo(2);
    }

    private Lotto createLotto(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }
}
