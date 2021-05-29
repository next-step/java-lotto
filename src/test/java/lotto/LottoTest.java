package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoRank.FIRST;
import static lotto.LottoRank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("로또 번호가 당첨 번호와 일치하는 갯수를 반환하는 테스트")
    @ParameterizedTest
    @MethodSource("countMatchNumberTest")
    void countCollectLottoNumber_일치하는_로또_번호_갯수(List<LottoNumber> userLottoNumbers, List<LottoNumber> winLottoNumbers, LottoRank expectedRank, LottoNumber bonusNumber) {
        Lotto lotto = new Lotto(() -> new LottoNumbers(userLottoNumbers));
        LottoRank lottoRank = lotto.compareWinLotto(new Lotto(() -> new LottoNumbers(winLottoNumbers)), bonusNumber);
        assertThat(lottoRank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> countMatchNumberTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        , Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        , FIRST
                        , new LottoNumber(10)),
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        , Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(9))
                        , SECOND
                        , new LottoNumber(6))
        );
    }
}
