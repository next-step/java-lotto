package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Collections.EMPTY_LIST;
import static lotto.domain.WinningResult.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WinningResultTest {

    private Lotto answerLotto;
    private static final LottoNumber BONUS_LOTTO_NUMBER = new LottoNumber(7);

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
            "10000, 6, 200000", //1등
            "10000, 5, 3000",   //2등
            "10000, 4, 5",      //4등
            "10000, 3, 0.5",    //5등
    })
    void get_profit_rate_when_fourth(final int money, final int matchCount, final float expectedProfitRate) {
        //given
        final WinningResult winningResult = new WinningResult(answerLotto, BONUS_LOTTO_NUMBER);

        //when
        winningResult.addLottoResult(LottoResult.findByMatchCount(matchCount, true));
        final double profitRate = winningResult.getProfitRate(new Money(money));

        //then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @DisplayName("로또번호가 일치하는 갯수와 보너스번호에 따라 상금이 결정된다.")
    @ParameterizedTest
    @MethodSource("parametersForLottos")
    void lottos_result(final List<Lotto> lottos) {
        //given
        final WinningResult winningResult = new WinningResult(answerLotto, BONUS_LOTTO_NUMBER);

        //when
        winningResult.matchWinningLotto(new Lottos(lottos, EMPTY_LIST));
        final Map<LottoResult, Integer> lottoResultCounts = winningResult.getLottoResultCounts();

        //then
        assertThat(lottoResultCounts.get(LottoResult.FIRST)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.SECOND)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.THIRD)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.FOURTH)).isEqualTo(1);
        assertThat(lottoResultCounts.get(LottoResult.FIFTH)).isEqualTo(2);
    }

    static Stream<Arguments> parametersForLottos() {
        final List<LottoNumber> firstLottoNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        final List<LottoNumber> secodeLottoNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), BONUS_LOTTO_NUMBER);
        final List<LottoNumber> thirdLottoNumbers = Arrays.asList(
                new LottoNumber(11), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        final List<LottoNumber> fourthLottoNumbers = Arrays.asList(
                new LottoNumber(11), new LottoNumber(22), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        final List<LottoNumber> fifthLottoNumbers1 = Arrays.asList(
                new LottoNumber(11), new LottoNumber(22), new LottoNumber(33),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        final List<LottoNumber> fifthLottoNumbers2 = Arrays.asList(
                new LottoNumber(1), new LottoNumber(22), new LottoNumber(33),
                new LottoNumber(44), new LottoNumber(5), new LottoNumber(6));
        final List<LottoNumber> noneLottoNumbers = Arrays.asList(
                new LottoNumber(11), new LottoNumber(22), new LottoNumber(33),
                new LottoNumber(44), new LottoNumber(5), new LottoNumber(6));

        return Stream.of(arguments(Arrays.asList(
                new Lotto(firstLottoNumbers), //LottoResult.FIRST
                new Lotto(secodeLottoNumbers), //LottoResult.SECOND
                new Lotto(thirdLottoNumbers), //LottoResult.THIRD
                new Lotto(fourthLottoNumbers), //LottoResult.FOURTH
                new Lotto(fifthLottoNumbers1), //LottoResult.FIFTH
                new Lotto(fifthLottoNumbers2), //LottoResult.FIFTH
                new Lotto(noneLottoNumbers) //LottoResult.NONE
        )));
    }

    @DisplayName("로또번호에 보너스번호가 포함되어선 안된다.")
    @Test
    void lotto_number_must_not_include_bonus_number() {
        //given
        final LottoNumber duplicatedLottoNumber = new LottoNumber(6);

        //when,then
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningResult(answerLotto, duplicatedLottoNumber))
                .withMessageMatching(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }
}
