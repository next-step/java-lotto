package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LotteriesTest {

    private static final int FIVE_PLAYS = 5;

    private static final Lotteries FIVE_LOTTERIES = new Lotteries(FIVE_PLAYS);

    @ParameterizedTest(name = "로또 플레이 횟수 입력에 맞춰 로또를 생성한다.")
    @ValueSource(ints = {0,2})
    void lotteryCreateByPlaysTest(int plays) {
        assertThat(new Lotteries(plays).size()).isEqualTo(plays);
    }

    @Test
    @DisplayName("1급 컬렉션에서 취급하는 불변값은 추가 삭제 수정을 할 수 없다.")
    void immutableListTest() {
        assertThatThrownBy(() -> FIVE_LOTTERIES.immutableGetLotteries()
                .add(new SixLotteryNumbers()))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
