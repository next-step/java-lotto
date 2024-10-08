import model.Lotto;
import model.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("Lotto 클래스 생성")
    void lottoInstantiationTest() {
        //given
        final List<Integer> numbers = List.of(8, 21, 23, 41, 42, 43);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("Lotto 클래스 생성 - 당첨 번호 포함")
    void lottoInstantiationTest_withWinnerNumber() {
        //given
        final List<Integer> numbers = List.of(8, 21, 23, 41, 42, 43);
        final List<Integer> winnerNumbers = List.of(8, 21, 23, 41, 42, 43);

        //when
        Lotto lotto = new Lotto(numbers);
        lotto.calPrize(winnerNumbers);

        //then
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(numbers);
        Assertions.assertThat(lotto.getPrize()).isEqualTo(Prize.PRIZE6);
    }
}
