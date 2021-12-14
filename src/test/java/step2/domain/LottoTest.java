package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("생성된 로또 번호는 6개이다.")
    @Test
    void generate() {
        Lotto lotto = LottoFactory.generate();
        int size = lotto.size();
        assertThat(size).isEqualTo(6);
    }

    @DisplayName("생성된 로또 번호는 1~45중 하나다.")
    @ParameterizedTest
    @MethodSource("generateLottoNumbers")
    void lottoNumberRangeCheck(int lottoNumber) {
        assertThat(lottoNumber).isGreaterThan(0);
        assertThat(lottoNumber).isLessThan(46);
    }

    private static List<Integer> generateLottoNumbers() {
        return LottoFactory.generate().getLottoNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    @DisplayName("Lotto에 로또 당첨 번호를 전달하면 일치하는 번호의 개수를 알 수 있다.")
    @Test
    void getWinningInfo() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(winningNumbers);
        Lotto lotto = LottoFactory.generate();
        int numberOfMatching = lotto.numberOfMatching(lottoWinningNumbers);
        assertThat(numberOfMatching).isGreaterThanOrEqualTo(0);
        assertThat(numberOfMatching).isLessThan(7);

    }

}
