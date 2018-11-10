package lotto.domain.validator;

import lotto.domain.common.Money;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by hspark on 07/11/2018.
 */
public class LottoPurchaseAmountValidatorTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test()
	public void test_0원() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("로또 구매 금액 이하입니다.");
		LottoPurchaseAmountValidator.valid(Money.ZERO);
	}

	@Test()
	public void test_1400원() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("1000원 단위로 입력해 주세요.");
		LottoPurchaseAmountValidator.valid(Money.of(1_400));
	}
}