package lottos.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LottoGameTest {

    private final int amountPerPiece = 1000;
    private final WinningPrizes winningPrizes = new WinningPrizes(Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000));
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(winningPrizes, amountPerPiece);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 14000, 30000})
    void 로또_게임_시작(final int purchaseAmount) {
        Lottos lottos = lottoGame.start(purchaseAmount);
        assertEquals(lottos.size(), purchaseAmount / amountPerPiece);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6:1", "4,5,6,7,8,9:3:1"}, delimiter = ':')
    void 로또_게임_결과(final String text, final int nameOfMatches, final int countOfMatches) {

        Assertions.assertDoesNotThrow(() -> {
            // given
            List<Integer> numbers = Arrays.stream(text.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            Lottos lottos = new Lottos(Collections.singletonList(new Lotto(numbers)));
            Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

            // when
            List<LottoResult> results = lottoGame.match(winningLotto, lottos);

            int prize = winningPrizes.getPrize(nameOfMatches);
            LottoResult lottoResult = results.stream()
                    .filter(result -> result.getPrize() == prize)
                    .findAny()
                    .orElseThrow(RuntimeException::new);
            Result result = lottoResult.getResult();

            //then
            assertEquals(result.getCountOfMatches(), countOfMatches);
        });

    }
}