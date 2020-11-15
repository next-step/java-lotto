package nextstep.step2.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
	@Test
	@DisplayName("로또 구입금 입력메시지 테스트")
	public void inputMessageTest() {
		InputView underTest = new InputView(new Scanner("14000"));
		int inputMoney = underTest.getInputMessage();
		assertThat(inputMoney).isEqualTo(14000);
	}

	@Test
	@DisplayName("로또 구입금액 비어있으면 안된다.")
	public void inputValidateCarNameTest() {
		InputView underTest = new InputView(new Scanner(""));
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.getInputMoney())
				.withMessage("구입금액은 필수입니다.");
	}
}
