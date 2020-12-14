package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static step2.domain.LottoTest.generateLottoNumber_1to6;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        List<Lotto> numbers = new ArrayList<>();
        numbers.add(generateLottoNumber_1to6());
        numbers.add(generateLottoNumber_1to6());
        lottoNumbers = new LottoNumbers(numbers);
    }

    @ParameterizedTest
    @MethodSource("generateLottoNumbersData")
    @DisplayName("당첨개수 기능 테스트 (로또(1-6) 2개를 샀을 때, 각각 당첨개수를 2개씩 가지고 있는다)")
    void check(String input, int expected) {
        String[] winningNumbers = input.split(",");

        for (String winningNumber : winningNumbers) {
            lottoNumbers.checkWinningLotto(new Number(Integer.parseInt(winningNumber)));
        }

        Assertions.assertEquals(lottoNumbers.winningResultMap().get(expected), 2);
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