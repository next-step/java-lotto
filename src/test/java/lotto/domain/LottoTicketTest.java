package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14","1000:1","3000:3"}, delimiter = ':')
    @DisplayName("로또 구매 가격 만큼 로또를 발급한다.")
    void lottoCountTest(int purchasePrice, int count) {
        LottoPurchasePrice lottoPurchasePrice = LottoPurchasePrice.valueOf(purchasePrice);
        LottoTicket lottoTicket = new LottoTicket(lottoPurchasePrice);
        assertThat(lottoTicket.getTicket()).hasSize(count);
    }

    @Test
    @DisplayName("getLottoWinningResult 메서드가 로또 결과 객체를 반환한다.")
    void getLottoWinningResultTest() {
        LottoPurchasePrice lottoPurchasePrice = LottoPurchasePrice.valueOf(1000);
        LottoTicket lottoTicket = new LottoTicket(lottoPurchasePrice);
        Lotto winningLotto = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)));
        assertThat(lottoTicket.getWinningResult(winningLotto))
                .isNotNull();
    }

    @Test
    @DisplayName("수동 로또를 포함하여 LottoTicket 객체를 생성할 때 자동 로또를 올바른 수만큼 발급한다.")
    void initLottoTicketByManualLottoTest() {
        LottoPurchasePrice lottoPurchasePrice = LottoPurchasePrice.valueOf(3000);
        Lotto lotto1 = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)));
        Lotto lotto2 = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)));
        List<Lotto> manualLottoTicket = List.of(lotto1, lotto2);

        LottoTicket lottoTicket = new LottoTicket(lottoPurchasePrice, manualLottoTicket);

        assertThat(lottoTicket.getTicket()).hasSize(3);
    }

    @Test
    @DisplayName("로또 구매 금액보다 많은 양의 수동 로또가 생성되면 예외가 발생한다.")
    void validateManualLottoCountThrowsExceptionWhenExceedsPurchaseAmount() {
        LottoPurchasePrice lottoPurchasePrice = LottoPurchasePrice.valueOf(1000);
        Lotto lotto1 = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)));
        Lotto lotto2 = new Lotto(Set.of(LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6)));
        List<Lotto> manualLottoTicket = List.of(lotto1, lotto2);

        assertThatThrownBy(() ->  new LottoTicket(lottoPurchasePrice, manualLottoTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액보다 많은 양의 수동 로또가 생성되었습니다.");
    }
}
