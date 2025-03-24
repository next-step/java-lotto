package lotto.domain;

import lotto.view.fake.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    @DisplayName("사용자는 요구사항에 따라 입력할 수 있다.")
    public void inputTest() {
        FakeInputView inputView = new FakeInputView("10000");
        assertThat(inputView.read()).isEqualTo("10000");
    }

    @Test
    @DisplayName("사용자는 구매 금액을 입력할 수 있다.")
    public void lottoTest() {
        FakeInputView inputView = new FakeInputView("10000");
        Money money = new Money(inputView.parseInt());
        assertThat(money).isEqualTo(new Money(10000));
    }

}
