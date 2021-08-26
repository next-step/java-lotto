package lotto.domain.type;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningTypeTest {
	@DisplayName(value = "일치 개수에 따른 당첨 타입 조회 테스트")
	@CsvSource(value = {"6,true,FIRST", "5,true,SECOND", "5,false,THIRD", "4,true,FOURTH", "3,true,FIFTH",
		"0,true,MISMATCH"})
	@ParameterizedTest
	void winningTypeByMatch(int matchCount, boolean matchBonus, String expect) {
		WinningType winningType = WinningType.getWinningType(matchCount, matchBonus);
		assertThat(winningType.name()).isEqualTo(expect);
	}
}