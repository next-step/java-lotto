package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class LottoTicketTest {

    @Test
    @DisplayName("로또를  생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_생성_테스트() {
        assertThatCode(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 티켓을 생성하는데 크기가 6보다 작으면 예외가 발생한다.")
    void 로또_번호_예외_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("로또 티켓을 생성하는데 번호가 중복되면 예외가 발생한다.")
    void 로또_번호_중복_예외_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(1, 1, 2, 3, 4, 5)));
    }
}
