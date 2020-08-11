package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = { 10000, 13000, 15000 } )
    public void buyingLottoTest(int money) {

        List<List<Integer>> lottoList = Lotto.pick(money);
        assertThat(lottoList.size()).isEqualTo(money / 1000);

        for (List<Integer> lotto : lottoList) {
            long LOTTO_SIZE = 6;
            assertThat(lotto.stream().distinct().count()).isEqualTo(LOTTO_SIZE);

            Optional<Integer> lastNumber = lotto.stream()
                    .max(Integer::compareTo);

            assertTrue(lastNumber.isPresent());
            assertThat(lastNumber.get()).isEqualTo(lotto.get(5));
        }
    }
}
