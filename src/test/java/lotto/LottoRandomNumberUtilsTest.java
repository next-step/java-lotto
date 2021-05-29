package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRandomNumberUtilsTest {
    @DisplayName("로또 번호 랜덤 생성 후 정상 생성 테스트")
    @Test
    void creatRandomLottoNumber_랜덤_로또_번호_생성() {
        LottoNumbers lottoNumbers = new LottoRandomNumberUtils().createRandomLotto();
        assertThat(lottoNumbers.lottoSize(6)).isTrue();
    }

    @DisplayName("로또 랜덤 번호 테스트 코드 위해 함수형 인터페이스 생성")
    @ParameterizedTest
    @MethodSource("createRandomLottoNumberTest")
    void createRandomLottoNumberTest_로또_넘버_테스트_넘기기_테스트(List<LottoNumber> userLotto, List<LottoNumber> winLotto, LottoRank expectRank, LottoNumber bonusNumber) {
        Lotto lotto = new Lotto(() -> new LottoNumbers(userLotto));
        LottoRank lottoRank = lotto.compareWinLotto(new Lotto(() -> new LottoNumbers(winLotto)), bonusNumber);
        assertThat(lottoRank).isEqualTo(expectRank);
    }

    static Stream<Arguments> createRandomLottoNumberTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7), new LottoNumber(7))
                        , Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7), new LottoNumber(8))
                        , FIRST, new LottoNumber(55)),
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7), new LottoNumber(8))
                        , Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7), new LottoNumber(9))
                        , SECOND, new LottoNumber(8)),
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7), new LottoNumber(8))
                        , Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7), new LottoNumber(9))
                        , THIRD, new LottoNumber(10))
        );
    }
}
