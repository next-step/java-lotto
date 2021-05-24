package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WinningResultTest {

    private Lotto answerLotto;

    @BeforeEach
    void setUp() {
        answerLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
    }

    @DisplayName("수익률은 당첨금/구매금액 이다.")
    @ParameterizedTest
    @CsvSource({
            "10000, 6, 200000",
            "10000, 5, 150",
            "10000, 4, 5",
            "10000, 3, 0.5",
    })
    void get_profit_rate_when_fourth(final int money, final int matchCount, final float expectedProfitRate) {
        //given
        final WinningResult winningResult = new WinningResult(answerLotto);

        //when
        winningResult.addLottoResult(LottoResult.findByMatchCount(matchCount));
        final double profitRate = winningResult.getProfitRate(new Money(money));

        //then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @DisplayName("로또번호가 일치하는 갯수에 따라 상금이 결정된다.")
    @ParameterizedTest
    @MethodSource("parametersForLottos")
    void lottos_result(final List<Lotto> lottos) {
        //given
        final WinningResult winningResult = new WinningResult(answerLotto);

        //when
        winningResult.matchWinningLotto(lottos);
        final Map<LottoResult, Integer> lottoResultCounts = winningResult.getLottoResultCounts();

        //then
        assertThat(lottoResultCounts.get(LottoResult.FIRST)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.SECOND)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.THIRD)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.FOURTH)).isEqualTo(2);
    }

    static Stream<Arguments> parametersForLottos() {
        return Stream.of(arguments(Arrays.asList(
                new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), //LottoResult.FIRST
                new Lotto(Arrays.asList(new LottoNumber(11), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), //LottoResult.SECOND
                new Lotto(Arrays.asList(new LottoNumber(11), new LottoNumber(22), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), //LottoResult.THIRD
                new Lotto(Arrays.asList(new LottoNumber(11), new LottoNumber(22), new LottoNumber(33),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), //LottoResult.FOURTH
                new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(22), new LottoNumber(33),
                        new LottoNumber(44), new LottoNumber(5), new LottoNumber(6))), //LottoResult.FOURTH
                new Lotto(Arrays.asList(new LottoNumber(11), new LottoNumber(22), new LottoNumber(33),
                        new LottoNumber(44), new LottoNumber(5), new LottoNumber(6))) //LottoResult.NONE
        )));
    }
}
