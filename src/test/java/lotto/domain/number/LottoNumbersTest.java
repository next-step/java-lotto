package lotto.domain.number;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoNumbers 클래스 테스트")
public class LottoNumbersTest {
    @DisplayName("NumberGenerator 타입을 주입 받아 LottoNumbers 객체를 생성할 수 있다.")
    @Test
    void createLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGenerator());

        assertThat(lottoNumbers.getNumbers()).hasSize(6);
    }

    @DisplayName("WinningNumbers와 비교하여 존재하는 갯수를 리턴할 수 있다.")
    @Test
    void matchCount() {
        String winningNumberString = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberString);

        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        LottoNumbers lottoNumbers = new LottoNumbers(fixedNumberGenerator);

        int matchCount = lottoNumbers.matchCount(winningNumbers);

        assertThat(matchCount).isEqualTo(fixedNumberGenerator.getNumbers().size());
    }

    @DisplayName("로또 번호를 포함하는지 확인할 수 있다.")
    @Test
    void contains() {
        LottoNumber lottoNumber = new LottoNumber(1);
        LottoNumbers lottoNumbers = new LottoNumbers(new FixedNumberGenerator());

        boolean contains = lottoNumbers.contains(lottoNumber);

        assertThat(contains).isTrue();
    }

    private static class FixedNumberGenerator implements NumberGenerator {

        @Override
        public List<Integer> getNumbers() {
            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }
    }
}
