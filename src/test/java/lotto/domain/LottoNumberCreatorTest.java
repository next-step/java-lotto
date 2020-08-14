package lotto.domain;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.StringResources;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberCreatorTest {

    @ParameterizedTest
    @ValueSource(ints = { 10000, 13000, 15000 } )
    void buyingLottoSuccess(int money) {

        List<LottoNumber> lottoNumberList = LottoCreator.create(money);
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

    @ParameterizedTest
    @ValueSource(ints = { 0, -1000 } )
    void input0OrNegativeMoney(int money) {

        assertThatIllegalArgumentException().isThrownBy(() -> LottoCreator.create(money))
                                            .withMessage(StringResources.ERR_MUST_BUY);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 500, 1500 } )
    void wrongMoneyUnit(int money) {

        assertThatIllegalArgumentException().isThrownBy(() -> LottoCreator.create(money))
                                            .withMessage(StringResources.ERR_WRONG_UNIT);
    }
}
