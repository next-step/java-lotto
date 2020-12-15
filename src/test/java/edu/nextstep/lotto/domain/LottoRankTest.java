package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoRank: 당첨 등수를 담고 있는 Enum")
class LottoRankTest {

	@DisplayName("from: 로또 번호가 몇개 일치하는지를 인자로 받아서 등수에 해당하는 Enum을 리턴함")
	@ParameterizedTest
	@CsvSource(value = {"6,FIRST", "5,THIRD", "4,FOURTH", "3,FIFTH"})
	void from(int number, LottoRank lottoRank) {
		assertThat(LottoRank.from(number))
			.isPresent()
			.hasValue(lottoRank);
	}

	@DisplayName("from: 일치하는 Enum이 없으면 null을 Optional로 감싸 리턴함")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 2, 7})
	void from(int number) {
		assertThat(LottoRank.from(number))
			.isNotPresent();
	}
}