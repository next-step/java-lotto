package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.type.Prize;
import step2.exception.InvalidLottoNumberCountException;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTest {

    @Test
    @DisplayName("6개 초과하는 숫자로 로또를 생성할 수 없다")
    public void invalid_lotto_number() {
        assertThatExceptionOfType(InvalidLottoNumberCountException.class)
            .isThrownBy(() -> {
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
            }).withMessageMatching("로또 숫자가 유효하지 않습니다");
    }

    @Test
    @DisplayName("숫자 비교를 통해 일치하는 수의 개수를 확인할 수 있다")
    public void integer_contain() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto prizeLotto = new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11));

        assertThat(lotto.prize(prizeLotto)).extracting(Prize::matchCount).isEqualTo(3);
    }

}
