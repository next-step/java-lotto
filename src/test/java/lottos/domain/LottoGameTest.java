package lottos.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LottoGameTest {

    private static final int AMOUNT_PER_PIECE = 1000;

    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 14000, 30000})
    void 로또_랜덤_게임_시작(final int purchaseAmount) {
        LottoGame lottoGame = new LottoGame(new LottoRandomGenerator());
        List<Lotto> lottos = lottoGame.start(purchaseAmount, AMOUNT_PER_PIECE);
        assertEquals(lottos.size(), purchaseAmount / AMOUNT_PER_PIECE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "4,5,6,7,8,9:3"}, delimiter = ':')
    void 로또_게임_결과(final String text, final int count) {

        // given
        List<Integer> numbers = Arrays.stream(text.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Lotto> lottos = Collections.singletonList(new Lotto(numbers));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        List<Result> results = winningLotto.match(lottos);
        Result result = results.stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);

        //then
        assertEquals(result.getWinningPrize(), WinningPrize.findByNumberOfMatchers(count));
    }
}