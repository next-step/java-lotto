package lotto.domain;

import lotto.domain.product.LotteryTicket;
import lotto.view.fake.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LotteryTicketTest {

    @Test
    @DisplayName("사용자는 구매 금액을 입력할 수 있다.")
    public void lottoTest() {
        FakeInputView inputView = new FakeInputView("10000");
        Money money = new Money(inputView.parseInt());
        assertThat(money).isEqualTo(new Money(10000));
    }

    @Test
    @DisplayName("로또 번호를 자동으로 생성할 수 있다.")
    public void makeLotto() {
        LotteryTicket lotteryTicket = new LotteryTicket();
        assertThat(lotteryTicket.getLottoNumbersCount()).isEqualTo(6);
    }


}
