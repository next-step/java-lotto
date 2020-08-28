package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {

    @DisplayName("lotto 판매자 객체 생성실패 - 금액부족")
    @Test
    void newInstance() {
        //given
        int money = 999;

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoSeller(money))
              .withMessage("구입금액이 부족합니다.");
    }

    @DisplayName("금액을 받아서 발급가능한 숫자만큼 로또 티켓을 생성해서 반환한다.")
    @Test
    void sellTickets() {
        int money = 1_000;

        LottoSeller lottoSeller = new LottoSeller(money);
        List<LottoTicket> actual = lottoSeller.sellTickets();

        assertEquals(1, actual.size());
    }

    @DisplayName("숫자로 이루어진 문자열을 받아서 로또 티켓을 생성한다.")
    @Test
    void getWinningTicket() {
        //given
        String lottoStringValues = "1, 2, 3, 4, 5, 6";
        int money = 1_000;
        LottoSeller lottoSeller = new LottoSeller(money);

        //when
        LottoTicket winningTicket = lottoSeller.getWinningTicket(lottoStringValues);

        //then
        Set<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
              .mapToObj(LottoNumber::new).collect(Collectors.toSet());

        LottoTicket expected = new LottoTicket(lottoNumbers);
        assertEquals(expected, winningTicket);
    }
}