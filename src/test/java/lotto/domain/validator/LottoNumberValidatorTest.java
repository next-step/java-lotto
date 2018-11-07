package lotto.domain.validator;

import lotto.domain.LottoTicket;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hspark on 07/11/2018.
 */
public class LottoNumberValidatorTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	public LottoNumberValidator lottoNumberValidator;

	@Before
	public void setUp() {
		lottoNumberValidator = new LottoNumberValidator();
	}

	@Test
	public void test_정상() {
		List<Integer> previousLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
		LottoTicket previousLottoTicket = LottoTicket.newInstanceByManual(previousLottoNumber);
		lottoNumberValidator.valid(previousLottoTicket);
	}

	@Test
	public void test_이전_로또번호가_46_이상일때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("잘못된 로또 번호입니다.");

		List<Integer> previousLottoNumber = Arrays.asList(46, 47, 48, 49, 50, 51);
		LottoTicket previousLottoTicket = LottoTicket.newInstanceByManual(previousLottoNumber);
		lottoNumberValidator.valid(previousLottoTicket);
	}

	@Test
	public void test_이전_로또번호가_0_이하일때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("잘못된 로또 번호입니다.");

		List<Integer> previousLottoNumber = Arrays.asList(0, 1, 2, 3, 4, 5);
		LottoTicket previousLottoTicket = LottoTicket.newInstanceByManual(previousLottoNumber);
		lottoNumberValidator.valid(previousLottoTicket);
	}

	@Test
	public void test_이전_로또번호에_숫자_중복이_있을때() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("중복은 허용되지 않습니다.");

		List<Integer> previousLottoNumber = Arrays.asList(0, 1, 2, 3, 5, 5);
		LottoTicket previousLottoTicket = LottoTicket.newInstanceByManual(previousLottoNumber);
		lottoNumberValidator.valid(previousLottoTicket);
	}
}