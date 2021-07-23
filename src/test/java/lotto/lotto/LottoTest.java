package lotto.lotto;

import lotto.helper.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구매 정보를 담고 있는 로또 클래스")
public class LottoTest {

    @DisplayName("로또 구매 정보는 구매 금액과 로또 티켓 그룹을 가지고 생성 한다.")
    @Test
    void initLotto() {
        int payment = 10_000;
        LottoTickets lottoTickets = Generator.autoLottoTickets(5);

        assertThat(Lotto.init(payment, lottoTickets)).isNotNull();
    }

    @DisplayName("구매 금액이 음수이거나 로또 그룹이 null 일 경우 예외를 발생한다.")
    @MethodSource
    @ParameterizedTest
    void initLottoException(int payment, LottoTickets lottoTickets) {
        assertThatThrownBy(() -> Lotto.init(payment, lottoTickets)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> initLottoException() {
        return Stream.of(
                Arguments.of(-1, Generator.autoLottoTickets(5)),
                Arguments.of(1, null),
                Arguments.of(-1, null)
        );
    }

    @DisplayName("당첨 번호를 전달 받아 당첨 정보를 반환한다.")
    @Test
    void matchPrize() {

    }
}
