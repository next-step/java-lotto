package lotto.domain.validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hspark on 07/11/2018.
 */
public class PreviousWinningNumberValidatorTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	public PreviousWinningNumberValidator previousWinningNumberValidator;

	@Before
	public void setUp() {
		previousWinningNumberValidator = new PreviousWinningNumberValidator();
	}

	@Test
	public void test_정상() {
		List<Integer> previousLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
		previousWinningNumberValidator.valid(previousLottoNumber);
	}

	@Test
	public void test_이전_로또번호가_46_이상일때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("잘못된 로또 번호입니다.");

		List<Integer> previousLottoNumber = Arrays.asList(46, 47, 48, 49, 50, 51);
		previousWinningNumberValidator.valid(previousLottoNumber);
	}

	@Test
	public void test_이전_로또번호가_0_이하일때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("잘못된 로또 번호입니다.");

		List<Integer> previousLottoNumber = Arrays.asList(0, 1, 2, 3, 4, 5);
		previousWinningNumberValidator.valid(previousLottoNumber);
	}

	@Test
	public void test_이전_로또번호에_숫자_중복이_있을때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("중복은 허용되지 않습니다.");

		List<Integer> previousLottoNumber = Arrays.asList(0, 1, 2, 3, 5, 5);
		previousWinningNumberValidator.valid(previousLottoNumber);
	}
}