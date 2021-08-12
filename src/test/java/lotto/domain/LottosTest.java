package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    /**
     * * 금액만큼 로또 리스트 생성(구매 금액 1000원에 로또 1개) 기능
     * * 로또 리스트 정렬 기능
     */

    @DisplayName("금액 만큼 로또 생성(1000원에 로또 1개)")
    @ParameterizedTest
    @CsvSource(value = {"1000:1","2000:2","3000:3","4000:4"}, delimiter = ':')
    void createLottoList_happyCase(int purchaseAmount, int excepted) {
        Lottos.create(purchaseAmount);
        assertThat(Lottos.size()).isEqualTo(excepted);
    }

    @DisplayName("금액 만큼 로또 생성(1000원에 로또 1개)")
    @ParameterizedTest
    @ValueSource(ints = {0,1500,2500,999})
    @NullAndEmptySource
    void createLottoList_blueCase(int purchaseAmount) {
        assertThatThrownBy(() -> Lottos.create(purchaseAmount))
                .isInstanceOf(RuntimeException.class);
    }

}
