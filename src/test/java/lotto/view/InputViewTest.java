package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.UserPaid;
import lotto.view.fake.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {

    @Test
    @DisplayName("사용자는 요구사항에 따라 입력할 수 있다.")
    public void inputTest() {
        FakeInputView inputView = new FakeInputView("10000");
        assertThat(inputView.read()).isEqualTo("10000");
    }

    @Test
    @DisplayName("사용자가 구매 금액을 입력하면 구매 개수를 알 수 있다.")
    public void countLottoTest() {
        FakeInputView inputView = new FakeInputView("10000");

        Integer count = new UserPaid(new Money(inputView.parseInt()))
                .getUserCountBy(new Lotto());
        assertThat(count).isEqualTo(10);
    }

    @Test
    @DisplayName("사용자는 최종 로또 번호를 입력할 수 있다.")
    public void makeInputLottoNumber() {
        FakeInputView inputView = new FakeInputView("5, 6, 7, 8, 9, 10");
        Lotto lotto = new Lotto(inputView.read());
        assertThat(lotto.getLottoNumbersCount()).isEqualTo(6);
    }
}
