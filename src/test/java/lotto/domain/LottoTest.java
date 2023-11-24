package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 테스트")
class LottoTest {

    @DisplayName("45개 이하의 숫자 6개를 가진다.")
    @Test
    void checkLottoNumber() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        for (LottoNumber number : lotto.getNumbers()) {
            Assertions.assertTrue(number.getLottoNumber() <= 45);
        }
    }

    @DisplayName("로또가 가지고 있는 번호는 6개를 초과할 수 없다.")
    @Test
    void checkLottoSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(List.of(1,2,3,4,5,6,7));
        });
    }

    @DisplayName("중복된 로또 번호가 존재하는지 확인한다.")
    @Test
    void checkDuplicateNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(List.of(1,1,3,4,5,6));
        });
    }

    @DisplayName("로또 당첨 개수를 확인한다.")
    @Test
    void countWinning() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(List.of(4,5,6,7,8,9));
        Assertions.assertEquals(lotto.countWinningNumber(winningLotto.getNumbers()), 3);
    }

    @DisplayName("로또 번호가 오름차순인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3", "3:5", "4:6", "5:7"}, delimiter = ':')
    void checkSortNumber(int index, int expectedNumber) {
        Lotto lotto = new Lotto(List.of(1,5,2,6,3,7));
        List<LottoNumber> numbers = lotto.getNumbers();

        Assertions.assertEquals(numbers.get(index).getLottoNumber(), expectedNumber);
    }
}
