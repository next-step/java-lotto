import model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("model.Lotto 클래스 생성")
    void lottoInstantiationTest() {
        //given
        final List<Integer> numbers = List.of(8, 21, 23, 41, 42, 43);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }
}
