package lotto.domain.validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by hspark on 07/11/2018.
 */
public class LottoPurchaseAmountValidatorTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	public LottoPurchaseAmountValidator purchaseAmountValidator;

	@Before
	public void setUp() {
		purchaseAmountValidator = new LottoPurchaseAmountValidator();
	}

	@Test()
	public void test_0원() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("로또 구매 금액 이하입니다.");
		purchaseAmountValidator.valid(0);
	}

	@Test()
	public void test_1400원() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("1000원 단위로 입력해 주세요.");
		purchaseAmountValidator.valid(1400);
	}
}