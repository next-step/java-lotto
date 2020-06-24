package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또에서 사용하는 번호가 아니면 Fail")
    @ValueSource(ints = {0, 46, -1, 100, -100})
    void FailIfLottoNumberIsNotLottoUsageNumber(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 컬렉션이 Lotto 번호 범위의 Lotto Number를 가지고 있는 지 테스트")
    void IsLottoCollectionEqualWithExpected() {
        List<LottoNumber> lottoCollection = LottoNumber.getLottoNumberCollection();

        for (int i = 1; i <= 45; i++) {
            LottoNumber actual = lottoCollection.get(i-1);
            LottoNumber expected = new LottoNumber(i);

            assertThat(actual).isEqualTo(expected);
        }
    }

}
