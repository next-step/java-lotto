package lotto.domain;

import lotto.util.StringSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = LottoMachine.instance();
    }

    @Test
    @DisplayName("당첨 로또 번호 생성 테스트")
    void winning_lotto_number_test() {
        // given & when
        LottoNumbers lottoNumbers = new LottoNumbers(StringSplitter.splitText("1,2,3,4,5,6"));
        WinningLotto winningLotto = new WinningLotto.Builder()
                .winningLottoTicket(lottoMachine.generateManualLottoNumbers(lottoNumbers))
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
            LottoNumbers lottoNumbers = new LottoNumbers(StringSplitter.splitText("1,2,3,4,5,6"));
            WinningLotto winningLotto = new WinningLotto.Builder()
                    .winningLottoTicket(lottoMachine.generateManualLottoNumbers(lottoNumbers))
                    .bonusBall(6)
                    .build();
        }).withMessageMatching("보너스 볼이 당첨 번호에 포함되어 있습니다. 다른 값을 입력하세요.");
    }

    @Test
    @DisplayName("보너스볼 일치 확인 테스트")
    void bonus_ball_match_test() {
        // given & when
        LottoNumbers lottoNumbers = new LottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 45"));
        WinningLotto winningLotto = new WinningLotto.Builder()
                .winningLottoTicket(lottoMachine.generateManualLottoNumbers(lottoNumbers))
                .bonusBall(7)
                .build();

        // then
        LottoNumbers matchTrueNumbers = new LottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 7"));
        assertThat(winningLotto.isBonusBall(lottoMachine.generateManualLottoNumbers(matchTrueNumbers))).isTrue();

        LottoNumbers matchFalseNumbers = new LottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 8"));
        assertThat(winningLotto.isBonusBall(lottoMachine.generateManualLottoNumbers(matchFalseNumbers))).isFalse();
    }

}
