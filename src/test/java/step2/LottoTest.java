package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoNo;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("Lotto를 생성하여 1~45 중 6개의 숫자를 중복없이 정렬하여 리턴한다.")
    void createLotto() {
        Lotto lotto = new Lotto();
        List<LottoNo> numbers = lotto.getNumbers();

        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers.get(0).getNumber()).isGreaterThan(0);
        assertThat(numbers.get(5).getNumber()).isLessThan(46);
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }

    @Test
    @DisplayName(value = "지정한 값으로 로또를 생성함.")
    void create_ListConstructor() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(list);
        for (LottoNo number : lotto.getNumbers()) {
            assertThat(list.contains(number.getNumber()));
        }
    }
}
