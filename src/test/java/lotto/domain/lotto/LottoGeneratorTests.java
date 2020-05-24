package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTests {
    @DisplayName("정적 팩터리 메서드로 로또 티켓을 만들 수 있다.")
    @Test
    void factoryCreateTest() {
        LottoTicket lottoTicket = LottoGenerator.create();
        assertThat(lottoTicket).isNotNull();
    }

    @DisplayName("임의의 수로 이루어진 로또 티켓을 생성할 수 있다.")
    @Test
    void randomTicketTest() {
        assertThat(LottoGenerator.create()).isInstanceOf(LottoTicket.class);
    }

    @DisplayName("숫자 여섯개를 입력 받아서 로또 티켓을 발급 할 수 있어야 한다.")
    @Test
    void manualTicketTest() {
        LottoTicket lottoTicket = LottoGenerator.createManualByIntList(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @DisplayName("쉼표로 구분된 문자열을 입력받아서 LottoTicket을 생성할 수 있다.")
    @Test
    void createLottoTicketFromStringTest() {
        assertThat(LottoGenerator.createFromString("1,2,3,4,5,6")).isInstanceOf(LottoTicket.class);
    }

    @DisplayName("문자열로 생성 시 null이나 빈 문자열로 생성할 수 없다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"  ", ""})
    void createLottoTicketFromStringValidationTest(String invalidInput) {
        assertThatThrownBy(() -> LottoGenerator.createFromString(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
