package lotto.view;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력 UI-VIEW 테스트")
public class InputViewTest {

	@Test
	@DisplayName("입력한 당첨번호 문자열을 숫자형 리스트로 변환 테스트")
	void toNumbers() {
		String inputNumbers = "1,2,3,4,5,6";
		List<Integer> numbers = InputView.toNumbers(inputNumbers, InputView.INPUT_LOTTO_NUMBERS_DELIMITER);

		assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
	}

	@Test
	@DisplayName("입력받은 구입금액 문자열이 정상일때 변환이 제대로 되는지 테스트")
	void inputPurchaseAmount() {
		PurchaseAmount purchaseAmount1 = new PurchaseAmount(1000);
		PurchaseAmount purchaseAmount2 = InputView.toPurchaseAmount("1000");
		assertThat(purchaseAmount1).isEqualTo(purchaseAmount2);
	}

	@Test
	@DisplayName("입력받은 구입금액 문자열이 비정상일때 null을 반환하는지 테스트")
	void inputWrongPurchaseAmount() {
		PurchaseAmount purchaseAmount = InputView.toPurchaseAmount("abcdef");
		assertThat(purchaseAmount).isNull();
	}

}
