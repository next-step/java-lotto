import Lotto.LotterNumbers;
import Lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    @Test
    @DisplayName("로또번호 비교 맞은갯수를 반환한한다")
    void compareLotto() {

        LotterNumbers lotterNumbers = LotterNumbers.of(List.of(1, 2, 3, 4, 5, 6));


        Lotto lotto = Lotto.of(lotterNumbers);

        Integer[] userNumbers = {1, 2, 3, 4, 5, 6};

        assertThat(lotto.compareNumbers(List.of(userNumbers))).isEqualTo(6);

    }
}
