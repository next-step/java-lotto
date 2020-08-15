package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberCreatorTest {

    @ParameterizedTest
    @ValueSource(ints = { 10000, 13000, 15000 } )
    public void buyingLottoTest(int money) {

        List<LottoNumber> lottoNumberList = RandomLottoCreator.createLottoList(money);
        assertThat(lottoNumberList.size()).isEqualTo(money / 1000);

        for (LottoNumber lottoNumber : lottoNumberList) {

            Set<Integer> numbers = lottoNumber.getNumbers();

            // 중복 미허용
            assertThat(numbers.stream()
                    .distinct()
                    .count()
            ).isEqualTo(6);
        }
    }
}
