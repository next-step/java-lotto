package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

	@DisplayName("로또 번호 객체 비교 테스트")
	@Test
	void equals() {
		// given
		int number = 1;

		// then
		LottoNumber actual = new LottoNumber(number);

		// then
		assertThat(actual).isEqualTo(new LottoNumber(number));
	}

	@DisplayName("로또 번호 정렬 테스트")
	@Test
	void sort() {
		// given
		List<LottoNumber> lottoNumberList = new ArrayList<>();
		lottoNumberList.add(new LottoNumber(5));
		lottoNumberList.add(new LottoNumber(2));
		lottoNumberList.add(new LottoNumber(3));
		lottoNumberList.add(new LottoNumber(1));
		lottoNumberList.add(new LottoNumber(6));
		lottoNumberList.add(new LottoNumber(4));

		// when
		Collections.sort(lottoNumberList);

		// then
		assertThat(lottoNumberList).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
			new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
	}

}
