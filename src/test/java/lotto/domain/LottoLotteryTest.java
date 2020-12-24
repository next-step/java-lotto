package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoLotteryTest {
	@Test
	@DisplayName("로또 번호가 6개가 아니면 IllegalArgumentException이 발생한다.")
	void validateLottoNumberCount() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoLottery(Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(6),
				new LottoNumber(7)
			)))
			.withMessage(Message.INVALID_LOTTO_NUMBER_COUNT);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoLottery(Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5)
			)))
			.withMessage(Message.INVALID_LOTTO_NUMBER_COUNT);
	}

	@Test
	@DisplayName("로또 번호는 오름차순으로 정렬해서 저장한다.")
	void sortNumbersTest() {
		assertThat(new LottoLottery(Arrays.asList(
			new LottoNumber(5),
			new LottoNumber(3),
			new LottoNumber(1),
			new LottoNumber(4),
			new LottoNumber(2),
			new LottoNumber(6)
		)).getLottoNumbers())
			.hasSize(6)
			.containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
				new LottoNumber(5), new LottoNumber(6));
	}
}