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
    void countCollectLottoNumber_일치하는_로또_번호_갯수(List<Integer> userLotto, List<Integer> winLotto, LottoRank expectedRank, LottoBonusNumber bonusNumber) {
        Lotto lotto = new Lotto(() -> new LottoNumber(userLotto));
        LottoRank lottoRank = lotto.compareWinLottoNumber(new Lotto(() -> new LottoNumber(winLotto)), bonusNumber);
        assertThat(lottoRank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> countMatchNumberTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), FIRST, new LottoBonusNumber(10)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 9), SECOND, new LottoBonusNumber(6))
        );
    }

    @DisplayName("유저 로또 객체와 입력한 당첨 번호 객체가 같은지 테스트")
    @ParameterizedTest
    @MethodSource("equalUserLottoAndWinLotto")
    void isEqualUserLottoAndWinLotto(List<Integer> userRandomLotto, String winLottoInput) {
        Lotto userLotto = new Lotto(() -> new LottoNumber(userRandomLotto));
        Lotto winLotto = new Lotto(LottoValidationUtils.lottoNumberToList(winLottoInput));
        assertThat(userLotto).isEqualTo(winLotto);
    }

    static Stream<Arguments> equalUserLottoAndWinLotto() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), "2,1,6,4,3,5")
        );
    }
}
