package lotto.domain;

import lotto.domain.value.OrderPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StoreTest {

    @Test
    @DisplayName("상점에서 돈 입력했을 경우 돈의 양만큼 로또티켓 생성 테스트")
    void lottoCreateTest() {
        List<String> manualNumbers = Arrays.asList("1,2,3,4,5,6");
        LottoTicket lottoTicket = Store.purchaseTicket(new OrderPrice("3000"), manualNumbers);

        assertThat(lottoTicket.getLotto().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("상점에서 자동 n장, 수동 n장 살수 있는지 확인")
    void purchaseTest() {
        List<String> manualNumbers = Arrays.asList("1,2,3,4,5,6");
        LottoTicket lottoTicket = Store.purchaseTicket(new OrderPrice("2000"), manualNumbers);

        assertThat(lottoTicket.getLotto().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동 구매 번호에 null이 입력 되었을 때 오류 체크")
    void nullExceptionTest() {

        assertThatThrownBy(() ->
                Store.purchaseTicket(new OrderPrice("2000"), null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("수동 구매 갯수가 살 수 있는 티켓 개수를 초과 했을 때 오류 체크")
    void countExceptionTest() {

        List<String> manualNumbers = Arrays.asList("1,2,3,4,5,6","1,2,3,6,9,10","2,4,6,8,10,12");
        assertThatThrownBy(() ->
                Store.purchaseTicket(new OrderPrice("2000"), manualNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
