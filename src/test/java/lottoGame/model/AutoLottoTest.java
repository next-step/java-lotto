package lottoGame.model;

import lottoGame.model.lotto.AutoLotto;
import lottoGame.model.lotto.WinningLotto;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import lottoGame.model.lotto.lottoNumber.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AutoLottoTest {
    private static Stream<Arguments> provideIntInput() {
        return Stream.of(
                Arguments.of(List.of(
                        new DefaultLottoNumber(1),
                        new DefaultLottoNumber(2),
                        new DefaultLottoNumber(3),
                        new DefaultLottoNumber(4),
                        new DefaultLottoNumber(5),
                        new DefaultLottoNumber(6)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntInput")
    void countMatch(List<LottoNumber> winnerNum) {
        AutoLotto autoLotto = new AutoLotto(winnerNum);
        WinningLotto winningLotto = new WinningLotto(winnerNum);
        assertEquals(autoLotto.countMatch(winningLotto), 6);
    }
}