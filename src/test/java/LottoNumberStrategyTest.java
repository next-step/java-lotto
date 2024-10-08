import model.LottoNumberStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

public class LottoNumberStrategyTest {
    @RepeatedTest(10)
    @DisplayName("로또 넘버 생성")
    void createLottoNumbersTest() {
        //given
        LottoNumberStrategy lottoNumberStrategy = new LottoNumberStrategy() {
        };

        //when
        List<Integer> numbers = lottoNumberStrategy.create();


        //then
        System.out.println(numbers);
        Assertions.assertThat(numbers).hasSize(6);
        int cnt = 0;
        for (Integer number : numbers) {
            if (number >= 1 && number <= 45) {
                cnt++;
            }
        }
        Assertions.assertThat(cnt).isEqualTo(6);
    }
}
