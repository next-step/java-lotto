package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("로또 한장을 테스트코드로 구매하여 일치 갯수 조회 테스트")
    @ParameterizedTest
    @MethodSource("countLottosCollectNumber")
    void countLottosCollectNumber_테스트코드로_구매_로또_일치_번호_테스트(List<LottoNumber> userRandomLotto, String winLottoInput, LottoRank expectlottoRank, int expectedCount, LottoNumber bonusNumber) {
        LottoBuy lottoBuy = new LottoBuy();
        Lottos lottos = lottoBuy.buyOneRandomLotto(() -> new LottoNumbers(userRandomLotto));
        Lotto winLotto = new Lotto(LottoValidationUtils.lottoNumberToListNumbers(winLottoInput));
        LottoRecord lottoRecord = lottos.compareWinLotto(winLotto, bonusNumber);
        assertThat(lottoRecord.isRecord(expectlottoRank, expectedCount)).isTrue();
    }

    static Stream<Arguments> countLottosCollectNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        , "2,1,6,4,3,5", FIRST, 1, new LottoNumber(2)),
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        , "2,1,8,9,3,7", FIRST, 0, new LottoNumber(2)),
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        , "10,1,4,5,3,6", SECOND, 1, new LottoNumber(2)),
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        , "10,1,4,5,3,6", THIRD, 0, new LottoNumber(2)),
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        , "10,1,4,5,3,6", THIRD, 1, new LottoNumber(11))
        );
    }
}
