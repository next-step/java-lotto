package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @DisplayName("숫자를 기반으로 LottoNumber 리스트 객체를 생성한다.")
    @Test
    void test01() {
        LottoNumbers lottoNumbers = createLottoNumbers(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.matchCount(createLottoNumbers(Set.of(1, 2, 3, 4, 5, 7)))).isEqualTo(5);
    }

    @DisplayName("일치하는 갯수를 구한다.")
    @Test
    void test02() {
        LottoNumbers lottoNumbers = createLottoNumbers(Set.of(1, 2, 3, 4, 5, 6));

        int result = lottoNumbers.matchCount(createLottoNumbers(Set.of(1, 2, 3, 10, 11, 12)));

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("2등 조건(5개와 보너스 번호 매치)과 매치하는지 구한다.")
    @Test
    void test03() {
        LottoNumbers lottoNumbers = createLottoNumbers(Set.of(1, 2, 3, 4, 5, 6));

        boolean result = lottoNumbers.isMatchFiveNumberAndBonusNumber(createLottoNumbers(Set.of(1, 2, 3, 4, 5, 7)), new LottoNumber(6));

        assertThat(result).isTrue();
    }

    private static LottoNumbers createLottoNumbers(Set<Integer> numbers) {
        Set<LottoNumber> result = new HashSet<>();
        for (Integer number : numbers) {
            result.add(new LottoNumber(number));
        }
        return new LottoNumbers(result);
    }
}
