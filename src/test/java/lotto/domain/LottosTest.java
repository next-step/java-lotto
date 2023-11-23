package lotto.domain;

import lotto.dto.WinningLottoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private Lottos lottos;
    private Lotto winningLotto;
    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(Arrays.asList(
                new Lotto("2, 3,4,5, 6,30"),//1500000
                new Lotto("2, 3,4,5, 6,33"),//30000000
                new Lotto("1, 2,3,4, 5,6"),//2000000000
                new Lotto("1, 2, 3, 5,6,40"),//1500000
                new Lotto("3, 4,5,6, 15,32"),//50000
                new Lotto("4, 5,6,2, 30,40"),//50000
                new Lotto("2, 5,6,9, 30,40"),//5000
                new Lotto("1, 2,3,9, 30,40"),//5000
                new Lotto("1, 2,6,9, 30,40")//5000
        ));
        winningLotto = new Lotto("1,2,3,4,5,6");
        lottoNumber = LottoNumber.of("33");
    }

    @DisplayName("가격만큼의 로또를 구매")
    @Test
    void 로또_구매() {
        Lottos lottos = new Lottos(Amount.of(14_000));
        assertThat(lottos.size()).isEqualTo(14);
    }

    @DisplayName("로또 총 당첨 금액을 리턴한다.")
    @Test
    void 총_당첨_금액() {
        assertThat(lottos.totalWinningAmount(new WinningLottoDTO(winningLotto, lottoNumber)))
                .isEqualTo(2_033_115_000l);
    }
    @DisplayName("당첨금액/구매금액 값을 소숫점 2자리까지 표현한 값을 리턴")
    @Test
    void 수익률() {
        assertThat(lottos.rateOfReturn(new WinningLottoDTO(winningLotto, lottoNumber)))
                .isEqualTo(new BigDecimal("225901.67"));
    }

    @DisplayName("1등 당첨 갯수")
    @Test
    void FIRST_당첨_개수() {
        assertThat(lottos.winningCorrectCount(new WinningLottoDTO(winningLotto, lottoNumber), Winning.FIRST))
                .isEqualTo(1);
    }
    @DisplayName("2등 당첨 갯수")
    @Test
    void SECOND_당첨_개수() {
        assertThat(lottos.winningCorrectCount(new WinningLottoDTO(winningLotto, lottoNumber), Winning.SECOND))
                .isEqualTo(1);
    }
    @DisplayName("3등 당첨 갯수")
    @Test
    void THIRD_당첨_개수() {
        assertThat(lottos.winningCorrectCount(new WinningLottoDTO(winningLotto, lottoNumber), Winning.THIRD))
                .isEqualTo(2);
    }
    @DisplayName("4등 당첨 갯수")
    @Test
    void FOURTH_당첨_개수() {
        assertThat(lottos.winningCorrectCount(new WinningLottoDTO(winningLotto, lottoNumber), Winning.FOURTH))
                .isEqualTo(2);
    }
    @DisplayName("5등 당첨 갯수")
    @Test
    void FIFTH_당첨_개수() {
        assertThat(lottos.winningCorrectCount(new WinningLottoDTO(winningLotto, lottoNumber), Winning.FIFTH))
                .isEqualTo(3);
    }

    @DisplayName("로또 게임 수")
    @Test
    void 게임_수() {
        assertThat(lottos.size()).isEqualTo(9);
    }

    @DisplayName("게임이 하나도 없는지 확인")
    @Test
    void 게임_존재_여부() {
        assertThat(lottos.isEmpty()).isFalse();
        Lottos emptyLottos = new Lottos(Amount.of(0));
        assertThat(emptyLottos.isEmpty()).isTrue();
    }
}