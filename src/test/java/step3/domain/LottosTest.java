package step3.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static step3.domain.factory.LottoFactory.produceLotto;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        List<Lotto> numbers = new ArrayList<>();
        numbers.add(produceLotto("1,2,3,4,5,6"));
        numbers.add(produceLotto("1,2,3,4,5,6"));
        lottos = new Lottos(numbers);
    }

    @ParameterizedTest
    @MethodSource("generateLottoNumbersData")
    @DisplayName("당첨개수 기능 테스트 (로또(1-6) 2개를 샀을 때, 각각 당첨개수를 2개씩 가지고 있는다)")
    void check(String input, int expected) {
        String[] winningNumbers = input.split(",");

        for (String winningNumber : winningNumbers) {
            lottos.checkWinningLotto(new LottoNumber(Integer.parseInt(winningNumber)),new LottoNumber(0));
        }

        Assertions.assertEquals(lottos.winningLottoResult().getLottos(expected).size(), 2);
    }

    static Stream<Arguments> generateLottoNumbersData() {
        return Stream.of(
                Arguments.of("1,2,3,14,15,16", 3),
                Arguments.of("1,2,3,4,15,16", 4),
                Arguments.of("1,2,3,4,5,16", 5),
                Arguments.of("1,2,3,4,5,6", 6)
        );
    }




}