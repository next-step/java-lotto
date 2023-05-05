package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    @DisplayName("로또 팩토리를 생성할때 0부터 45까지의 숫자가 초기화 되어야한다.")
    void LottoFactory_생성() {
        List<Integer> expectedNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            expectedNumbers.add(i);
        }
        List<Integer> numbers = LottoFactory.NUMBERS;
        assertThat(numbers).isEqualTo(expectedNumbers);
    }

    @Test
    @DisplayName("6의 다른 숫자를 갖는 로또를 생성한다.")
    void generateLottoNumbers_테스트(){
        List<Lotto> lottos = LottoFactory.generateLottoNumbers(3);
        for (Lotto lotto : lottos) {
            Set<LottoNumber> numbers = new HashSet<>(lotto.getLotto());
            assertThat(numbers).hasSize(6);
        }
    }

}
