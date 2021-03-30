package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTest {

    @Test
    @DisplayName("로또 번호 추출 테스트")
    void extractionLottoNumber() {
        Lotto lotto = Lotto.of(new RandomGenerator());
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("구매한 로또번호와 당첨번호가 일치하는 개수 반환 테스트")
    void getMatchCount() {
        List<Integer> referenceNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(new FixedGenerator(referenceNumbers));
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", 7);

        assertThat(lotto.getMatchCount(winningNumber)).isEqualTo(6);
    }

    @Test
    @DisplayName("구매한 로또번호에 당첨번호가 일치하는게 있으면 true")
    void isMatchBonus() {
        List<Integer> referenceNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto lotto = Lotto.of(new FixedGenerator(referenceNumbers));
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", 7);

        assertThat(lotto.isMatchBonus(winningNumber)).isTrue();
    }
}
