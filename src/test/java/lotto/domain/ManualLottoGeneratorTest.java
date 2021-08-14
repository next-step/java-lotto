package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("수동 로또 테스트")
class ManualLottoGeneratorTest {

    @Test
    @DisplayName("수동 로또 생성 테스트")
    void constructLottoTicketTest() {
        // given
        String[] lottoNumbers = {"1", "2", "3", "4", "5", "6"};
        LottoGenerator lottoGenerator = new ManualLottoGenerator(lottoNumbers);

        // when
        LottoTicket lottoTicket = lottoGenerator.generate();

        // then
        assertThat(lottoTicket).isEqualTo(new LottoTicket(lottoNumbers));
    }

    @Test
    @DisplayName("수동 로또 생성시 사이즈가 맞지 않을경우 예외처리")
    void constructLottoTicketExceptionTest() {
        assertThatThrownBy(() -> new ManualLottoGenerator("1", "2", "3", "4", "5").generate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("different number size");
    }
}