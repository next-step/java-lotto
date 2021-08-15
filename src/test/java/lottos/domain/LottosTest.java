package lottos.domain;

import lottos.converter.IntListConverter;
import lottos.domain.numbers.Numbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LottosTest {

    private LottoGenerator lottoGenerator = size -> Numbers.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6));

    @ParameterizedTest
    @CsvSource(value = {"0:0", "100:0", "1000:1", "10000:10"}, delimiter = ':')
    void 로또_구매가격으로_장수_검증(final int purchaseAmount, final int expect) {
        Lottos lottos = new Lottos(purchaseAmount, lottoGenerator);
        int size = lottos.count();
        assertEquals(size, expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,10:SECOND", "2,3,4,5,6,9:THIRD"}, delimiter = ':')
    void 로또_게임_결과_검증(@ConvertWith(IntListConverter.class) final List<Integer> numbers, final String rank) {

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

    @ParameterizedTest
    @MethodSource(value = {})
    @CsvSource(value = {"1,2,3,4,5,6:6,7,8,9,10,11:2"}, delimiter = ':')
    void 로또_합치기(@ConvertWith(IntListConverter.class) final List<Integer> numbers1,
                @ConvertWith(IntListConverter.class) final List<Integer> numbers2, final int actual) {

        // given
        Lotto lotto1 = new Lotto(numbers1);
        Lotto lotto2 = new Lotto(numbers2);
        Lottos lottos1 = new Lottos(Collections.singletonList(lotto1), lottoGenerator);
        Lottos lottos2 = new Lottos(Collections.singletonList(lotto2), lottoGenerator);

        // when
        Lottos lottos = lottos1.merge(lottos2);

        // then
        assertEquals(lottos.count(), actual);
        assertTrue(lottos.elements().contains(lotto1));
        assertTrue(lottos.elements().contains(lotto2));
    }


}
