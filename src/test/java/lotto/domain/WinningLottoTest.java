package lotto.domain;

import lotto.util.StringSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningLottoTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("당첨 로또 번호 생성 테스트")
    void winning_lotto_number_test() {
        // given & when
        WinningLotto winningLotto = new WinningLotto.WinningLottoBuilder()
                .winningLottoTicket(lottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,4,5,6")))
                .bonusBall(7)
                .build();

        // then
        assertThat(winningLotto.getWinningLottoTicket().getLottoTicketNumbers().size()).isEqualTo(6);
        assertThat(winningLotto.getWinningLottoTicket().getLottoTicketNumbers())
                .containsExactly(LottoNumber.ofNumber(1), LottoNumber.ofNumber(2), LottoNumber.ofNumber(3), LottoNumber.ofNumber(4), LottoNumber.ofNumber(5), LottoNumber.ofNumber(6));
    }

    @Test
    @DisplayName("보너스볼 중복 테스트")
    void bonus_ball_duplication_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            WinningLotto winningLotto = new WinningLotto.WinningLottoBuilder()
                    .winningLottoTicket(lottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,4,5,6")))
                    .bonusBall(6)
                    .build();
        }).withMessageMatching("보너스 볼이 당첨 번호에 포함되어 있습니다. 다른 값을 입력하세요.");
    }

    @Test
    @DisplayName("보너스볼 일치 확인 테스트")
    void bonus_ball_match_test() {
        // given & when
        WinningLotto winningLotto = new WinningLotto.WinningLottoBuilder()
                .winningLottoTicket(lottoMachine.createManualLottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 45")))
                .bonusBall(7)
                .build();

        // then
        assertThat(winningLotto.isBonusBall(lottoMachine.createManualLottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 7")))).isTrue();
        assertThat(winningLotto.isBonusBall(lottoMachine.createManualLottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 8")))).isFalse();
    }

}
