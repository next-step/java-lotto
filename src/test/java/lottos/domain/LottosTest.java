package lottos.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LottosTest {

    @Test
    void 로또_생성시_비어있을경우_에러() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lottos(new ArrayList<>()));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void 금액으로_로또_구매_불가능(final int purchaseAmount) {
        // 장당 1000원
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lottos(purchaseAmount));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10"}, delimiter = ':')
    void 금액으로_로또_구매_성공(final int purchaseAmount, final int expect) {
        // 장당 1000원
        Lottos lottos = new Lottos(purchaseAmount);
        int size = lottos.elements().size();
        assertEquals(size, expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "4,5,6,7,8,9:3"}, delimiter = ':')
    void 로또_게임_결과_검증(final String numbersText, final int count) {

        // given
        Lottos lottos = new Lottos(Collections.singletonList(new Lotto(numbersText)));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        List<LottoResult> lottoResults = lottos.match(winningLotto);
        LottoResult lottoResult = lottoResults.stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);

        //then
        assertEquals(lottoResult.getPrize(), Prize.findByNumberOfMatchers(count));
    }
}
