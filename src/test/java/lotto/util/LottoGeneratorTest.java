package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.factory.UserLottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

    @DisplayName("구매금액을 통해 로또 개수를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"14000,14", "2000,2"})
    void getLottoQuantity(final int purchasePrice, final int expected) {
        assertThat(UserLottoFactory.getLottoQuantity(purchasePrice)).isSameAs(expected);
    }

    @Test
    @DisplayName("구매금액이 1000원 미만이면 예외처리해야 한다.")
    void getLottoQuantity() {
        final int invalidPrice = 900;
        assertThatThrownBy(() -> UserLottoFactory.getLottoQuantity(invalidPrice))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
    }

//    @Test
//    @DisplayName("로또 번호에 중복값이 없어야 한다.")
//    void checkDuplicatedNumber() {
//        List<Integer> lottoNumbers = Lottos.getLottoNumbers();
//        List<Integer> distinctNumbers = lottoNumbers.stream().distinct().collect(Collectors.toList());
//
//        assertThat(lottoNumbers.size()).isEqualTo(distinctNumbers.size());
//    }
}
