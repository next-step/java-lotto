package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.Lotto;
import step4.domain.LottoNumber;
import step4.domain.Lottos;
import step4.domain.generator.LottoManualGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        List<Lotto> numbers = new ArrayList<>();
        numbers.add(new LottoManualGenerator().generate("1,2,3,4,5,6"));
        lottos = new Lottos(numbers);
    }

    @ParameterizedTest
    @MethodSource("generateLottoNumbersData")
    @DisplayName("로또를 구입한 후, 당첨번호와 비교해서 당첨된 개수를 가져오는 기능 테스트")
    void check(String input, int expected) {
        String[] winningNumbers = input.split(",");

        for (String winningNumber : winningNumbers) {
            lottos.checkWinningLotto(new LottoNumber(Integer.parseInt(winningNumber)),new LottoNumber(10));
        }

        Assertions.assertEquals(lottos.winningLottoResult().getLottos(expected).size(),1);
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