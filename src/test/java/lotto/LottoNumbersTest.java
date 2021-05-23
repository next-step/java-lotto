package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.generator.AutoLottoNumberGenerator;

public class LottoNumbersTest {

	@Test
	@DisplayName(value = "로또 넘버를 6개 입력받아야 하나의 로또 세트가 완성된다")
	void createLottoSet() {
		LottoNumbers lottoNumber = new LottoNumbers();
		lottoNumber.add(new LottoNumber(1));
		lottoNumber.add(new LottoNumber(2));
		lottoNumber.add(new LottoNumber(3));
		lottoNumber.add(new LottoNumber(4));
		lottoNumber.add(new LottoNumber(5));
		lottoNumber.add(new LottoNumber(6));
		assertThat(lottoNumber.isComplete()).isTrue();
	}

	@Test
	@DisplayName(value = "로또 넘버 개수가 6개 미만이면 false를 반환한다")
	void isCompleteLotto() {
		LottoNumbers lottoNumber = new LottoNumbers();
		lottoNumber.add(new LottoNumber(1));
		lottoNumber.add(new LottoNumber(2));
		assertThat(lottoNumber.isComplete()).isFalse();
	}

	@Test
	@DisplayName(value = "로또 넘버는 6개까지만 add가 가능하다")
	void addLessThanEqualSix() {
		LottoNumbers lottoNumber = new LottoNumbers();
		lottoNumber.add(new LottoNumber(1));
		lottoNumber.add(new LottoNumber(2));
		lottoNumber.add(new LottoNumber(3));
		lottoNumber.add(new LottoNumber(4));
		lottoNumber.add(new LottoNumber(5));
		lottoNumber.add(new LottoNumber(6));
		lottoNumber.add(new LottoNumber(7));
		lottoNumber.add(new LottoNumber(8));
		lottoNumber.add(new LottoNumber(9));
		assertThat(lottoNumber.isComplete()).isTrue();
	}

	@Test
	@DisplayName(value = "print 에 제공할 lotto 번호 message 검증")
	void lottoStringMessage() {
		AutoLottoNumberGenerator generator = new AutoLottoNumberGenerator(Arrays.asList(
			5, 6, 7, 8, 9, 10
		));
		LottoNumbers lotto = new LottoNumbers();
		generator.generate(lotto);
		System.out.println(lotto);
		assertThat(lotto.toString()).isEqualTo("[5, 6, 7, 8, 9, 10]");
	}

	@Test
	@DisplayName(value = "두개의 lottoNumbers 를 비교하면 일치하는 개수를 반환한다")
	void compareEqualsCount() {
		LottoNumbers win = mockLottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));
		LottoNumbers notSame = mockLottoNumbers(Arrays.asList(44, 45, 46, 1, 2, 3));
		LottoNumbers oneSame = mockLottoNumbers(Arrays.asList(45, 46, 1, 2, 3, 4));
		LottoNumbers twoSame = mockLottoNumbers(Arrays.asList(46, 1, 2, 3, 4, 5));
		LottoNumbers three = mockLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumbers fourSame = mockLottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7));
		LottoNumbers fiveSame = mockLottoNumbers(Arrays.asList(3, 4, 5, 6, 7, 8));
		LottoNumbers sixSame = mockLottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));

		assertThat(win.sameCount(notSame)).isEqualTo(0);
		assertThat(win.sameCount(oneSame)).isEqualTo(1);
		assertThat(win.sameCount(twoSame)).isEqualTo(2);
		assertThat(win.sameCount(three)).isEqualTo(3);
		assertThat(win.sameCount(fourSame)).isEqualTo(4);
		assertThat(win.sameCount(fiveSame)).isEqualTo(5);
		assertThat(win.sameCount(sixSame)).isEqualTo(6);
	}

	private LottoNumbers mockLottoNumbers(List<Integer> numbers) {
		return new LottoNumbers(numbers);
	}


}
