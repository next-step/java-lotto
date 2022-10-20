package lottoGame;

import lottoGame.model.lotto.WinningLotto;
import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RanksTest {

    @ParameterizedTest
    @EnumSource(Ranks.class)
    void findMatch(Ranks ranks) {
        List<Integer> matches = List.of(0, 3, 4, 5, 6);
        assertEquals(ranks.findMatch(matches), 1);
    }
}