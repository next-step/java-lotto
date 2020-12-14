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

import static step2.domain.LottoNumberGenerator.LOTTO_COUNT;
import static step2.domain.LottoNumberGenerator.START_NUMBER;

class LottoTest {

    Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = generateLottoNumber_1to6();
    }

    @ParameterizedTest
    @MethodSource("generateLottoData")
    @DisplayName("로또번호가 1,2,3,4,5,6일 때 당첨번호들과 일치하는 개수 기능 테스트 ")
    void equal_lottoNumber_count(String input, int expected) {
        String[] winningNumbers = input.split(",");

        for (String winningNumber : winningNumbers) {
            lotto.equalCheck(new LottoNumber(Integer.parseInt(winningNumber)));
        }

        Assertions.assertEquals(lotto.getCount(), expected);
    }


    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of("1,2,3,14,15,16", 3),
                Arguments.of("1,2,3,4,15,16", 4),
                Arguments.of("1,2,3,4,5,16", 5),
                Arguments.of("1,2,3,4,5,6", 6)
        );
    }

    public static Lotto generateLottoNumber_1to6() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = START_NUMBER; i <= LOTTO_COUNT; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return new Lotto(lottoNumbers);
    }
}