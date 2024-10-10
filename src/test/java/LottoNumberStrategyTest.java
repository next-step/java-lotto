import model.LottoNumberGenerate;
import model.LottoNumberGenerator;
import model.RandomLottoNumberGenerateImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumberStrategyTest {
    @Test
    @DisplayName("로또 넘버 생성")
    void createLottoNumbersTest() {
        //given
        LottoNumberGenerate lottoNumberGenerate = new RandomLottoNumberGenerateImpl();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(lottoNumberGenerate);

        final int priceOfALotto = 1000;
        final int totalPrice = 6000;

        //when
        List<List<Integer>> numbers = lottoNumberGenerator.run(totalPrice, priceOfALotto);


        //then
        System.out.println(numbers);
        Assertions.assertThat(numbers).hasSize(6);
        numbers.stream().flatMap(List::stream).forEach(it -> Assertions.assertThat(it).isBetween(1, 45));
    }
}
