import model.LottoNumberStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumberStrategyTest {
    @Test
    @DisplayName("로또 넘버 생성")
    void createLottoNumbersTest() {
        //given
        LottoNumberStrategy lottoNumberStrategy = new LottoNumberStrategy() {
        };

        //when
        List<List<Integer>> numbers = lottoNumberStrategy.create(6);


        //then
        System.out.println(numbers);
        Assertions.assertThat(numbers).hasSize(6);
        numbers.stream().flatMap(List::stream).forEach(it -> Assertions.assertThat(it).isBetween(1, 45));
    }
}
