package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.util.LottoMakeNumbers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoPrizesTest {

    private static final LottoNumber BONUS_NUMBER = LottoNumber.of(7);

    @DisplayName("생성된_Prize_개수_검증")
    @ParameterizedTest
    @MethodSource("provideLottoAndLottoWinning")
    void 생성된_Prize_개수_검증(Lottos lottos, LottoWinning winningLotto, int expected) {
        assertEquals(expected, LottoPrizes.of(lottos, winningLotto).stream().count());
    }

    private static Stream<Arguments> provideLottoAndLottoWinning() {
        final LottoWinning winningLotto = LottoWinning.of(
                Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")),
                BONUS_NUMBER
        );

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")));
        lottoList.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,7")));
        lottoList.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,7,8")));
        lottoList.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,7,8,9")));
        lottoList.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,7,8,9,10")));

        return Stream.of(
                Arguments.of(Lottos.of(lottoList), winningLotto, 5)
        );
    }
}