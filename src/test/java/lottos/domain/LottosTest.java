package lottos.domain;

import lottos.domain.numbers.Numbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LottosTest {

    private LottoGenerator lottoGenerator = size -> Numbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    void 로또_생성시_비어있을경우_에러() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lottos(new ArrayList<>(), lottoGenerator);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "100:0", "1000:1", "10000:10"}, delimiter = ':')
    void 로또_구매가격으로_장수_검증(final int purchaseAmount, final int expect) {
        Lottos lottos = new Lottos(purchaseAmount, lottoGenerator);
        int size = lottos.elements().size();
        assertEquals(size, expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,10:SECOND", "2,3,4,5,6,9:THIRD"}, delimiter = ':')
    void 로또_게임_결과_검증(final String numbersText, final String rank) {

        List<Integer> numbers = Arrays.stream(numbersText.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // given
        Lotto lotto = new Lotto(numbers);
        Lottos lottos = new Lottos(Collections.singletonList(lotto), lottoGenerator);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10);

        // when
        List<LottoResult> lottoResults = winningLotto.match(lottos);
        LottoResult lottoResult = lottoResults.stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);

        //then
        assertEquals(lottoResult.getPrize(), LottoPrize.valueOf(rank));
    }
}
