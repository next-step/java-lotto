package lotto.lotto;

import lotto.helper.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동 로또와 수동 로또를 묶기 위한 로또 번틀 클래스 테스트.")
class LottoBundleTest {

    @DisplayName("두개의 LottoTickets 를 가지고 초기화 한다.")
    @Test
    void init() {
        assertThat(LottoBundle.init(Generator.autoLottoTickets(0), Generator.autoLottoTickets(0))).isNotNull();
    }

    @DisplayName("LottoTickets 는 빈 값일수는 있지만 null 일 수는 없다. null 일 경우 예외를 던진다.")
//    @MethodSource
//    @ParameterizedTest
    void initException(LottoTickets autoLottoTickets, LottoTickets manualLottoTickets) {
    }
}
