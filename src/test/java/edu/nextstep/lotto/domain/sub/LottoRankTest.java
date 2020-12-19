package edu.nextstep.lotto.domain.sub;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoRank: 당첨 등수를 담고 있는 Enum")
class LottoRankTest {

	@DisplayName("from: 로또 번호가 몇개 일치하는지를 인자로 받아서 등수에 해당하는 Enum을 리턴함")
	@ParameterizedTest
	@CsvSource(value = {"6,FIRST", "5,THIRD", "4,FOURTH", "3,FIFTH", "2,NONE", "1,NONE", "0,NONE"})
	void from(int number, LottoRank lottoRank) {
		assertThat(LottoRank.from(number))
			.isPresent()
			.hasValue(lottoRank);
	}

	@DisplayName("from: 올바르지 않은 파라미터(0~6 범위 밖)은 빈 Optional이 리턴함")
	@ParameterizedTest
	@ValueSource(ints = {-1, 7})
	void from(int number) {
		assertThat(LottoRank.from(number))
			.isNotPresent();
	}
}