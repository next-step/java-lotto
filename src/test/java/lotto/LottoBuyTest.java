package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBuyTest {
    private LottoBuy lottoBuy;

    @BeforeEach
    void setUp() {
        lottoBuy = new LottoBuy();
    }

    @DisplayName("구매 금액 만큼 로또 구매 ( 가격은 1000원에 한장 )")
    @Test
    void countBuyLotto_구매_로또_갯수_검증_테스트() {
        Lottos lottos = lottoBuy.buyAutoLotto(14);
        assertThat(lottos.isCount(14)).isTrue();
    }

    @DisplayName("수동 구매와 자동 구매 후 로또 갯수 확인")
    @ParameterizedTest
    @MethodSource("buyLottoList")
    void countAutoAndManualLotto(List<String> manualNumbers, int autoNumberCount, int allCount) {
        LottoBuy lottoBuy = new LottoBuy();
        for (String manualNumber : manualNumbers) {
            lottoBuy.buyManualLotto(manualNumber);
        }
        Lottos lottos = lottoBuy.buyAutoLotto(autoNumberCount);
        assertThat(lottos.isCount(allCount)).isTrue();
    }

    static Stream<Arguments> buyLottoList() {
        return Stream.of(
                Arguments.of(Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6"), 5, 7)
        );
    }
}
