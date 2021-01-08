package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoNumberUtils;

class LottoLotteryTest {
	@Test
	@DisplayName("로또 번호가 6개가 아니면 IllegalArgumentException이 발생한다.")
	void validateLottoNumberCount() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5,6,7")))
			.withMessage(Message.INVALID_LOTTO_NUMBER_COUNT);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoLottery(LottoNumberUtils.mapToListByComma("1,2,3,4,5")))
			.withMessage(Message.INVALID_LOTTO_NUMBER_COUNT);
	}

	@Test
	@DisplayName("로또 번호는 오름차순으로 정렬해서 저장한다.")
	void sortNumbersTest() {
		assertThat(new LottoLottery(LottoNumberUtils.mapToListByComma("5,3,1,4,2,6"))
			.getLottoNumbers())
			.hasSize(6)
			.containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4),
				LottoNumber.of(5), LottoNumber.of(6));
	}
}