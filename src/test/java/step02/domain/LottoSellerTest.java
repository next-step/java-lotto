package step02.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class LottoSellerTest {

    @ParameterizedTest
    @CsvSource({
        "1000, 1",
        "3000, 3",
        "238000, 238",
    })
    @DisplayName("가격 및 입력된 수동 로또에 맞는 로또 개수를 구매를 했는지 검증")
    void sellLottoCount(int price, int size) {
        then(LottoSeller.sell(price, List.of("1,2,3,4,5,6")).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000, 1, 999, 1500})
    @DisplayName("입력한 금액 validate 테스트")
    void validatePriceFail(int price) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoSeller.sell(price, List.of("1,2,3,4,5,6")));
    }

    @Test
    @DisplayName("자동 로또 개수가 0 미만인 케이스 에러 발생")
    void autoLottoCountIsMinus() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoSeller.sell(1000, List.of("1,2,3,4,5,6", "1,2,3,4,5,6")));
    }

    @Test
    @DisplayName("자동 로또 개수가 0개인 경우 수동 로또으로만 생성")
    void onlyManualLotto() {
        then(LottoSeller.sell(1000, List.of("1,2,3,4,5,6"))).isEqualTo(
            new LottoList(List.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6))))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("수동 로또가 비어있는 경우")
    void validateManualLottoNumbers(List<String> manualLottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoSeller.sell(1000, manualLottoNumbers));
    }
}