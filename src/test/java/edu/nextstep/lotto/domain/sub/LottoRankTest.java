package edu.nextstep.lotto.domain.sub;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoRank: 당첨 등수를 담고 있는 Enum")
class LottoRankTest {

	@DisplayName("valueOf: 로또 번호가 몇개 일치하는지를 인자로 받아서 등수에 해당하는 Enum을 리턴함")
	@ParameterizedTest
	@CsvSource(value = {
		"6,false,FIRST", "6,true,FIRST",
		"5,true,SECOND",
		"5,false,THIRD",
		"4,false,FOURTH", "4,true,FOURTH",
		"3,false,FIFTH", "3,true,FIFTH",
		"2,false,NONE", "1,false,NONE", "0,false,NONE"})
	void valueOf(int number, boolean isMatchBonus, LottoRank expectedRank) {
		assertThat(LottoRank.valueOf(number, isMatchBonus))
			.isPresent()
			.hasValue(expectedRank);
	}

	@DisplayName("valueOf: 올바르지 않은 파라미터(0~6 범위 밖)은 빈 Optional이 리턴함")
	@ParameterizedTest
	@ValueSource(ints = {-1, 7})
	void valueOf(int number) {
		assertThat(LottoRank.valueOf(number, false))
			.isNotPresent();
	}
}