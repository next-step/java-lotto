package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoCreatorTest {

    @ParameterizedTest
    @ValueSource(ints = { 10000, 13000, 15000 } )
    public void buyingLottoTest(int money) {

        List<Lotto> lottoList = LottoCreator.create(money);
        assertThat(lottoList.size()).isEqualTo(money / 1000);

        for (Lotto lotto : lottoList) {

            List<Integer> numbers = lotto.getNumbers();

            // 중복 미허용
            assertThat(numbers.stream()
                    .distinct()
                    .count()
            ).isEqualTo(6);

            // 최소값 == numbers[0]
            Optional<Integer> minNumber = numbers.stream()
                    .min(Integer::compareTo);

            assertTrue(minNumber.isPresent());
            assertThat(minNumber.get()).isEqualTo(numbers.get(0));

            // 최대값 == numbers[5]
            Optional<Integer> maxNumber = numbers.stream()
                    .max(Integer::compareTo);

            assertThat(maxNumber.get()).isEqualTo(numbers.get(5));
        }
    }
}
