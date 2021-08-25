package lotto.domain.type;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningTypeTest {
	@DisplayName(value = "일치 개수에 따른 당첨 타입 조회 테스트")
	@CsvSource(value = {"6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH", "0,MISMATCH"})
	@ParameterizedTest
	void winningTypeByMatch(int matchCount, String expect) {
		WinningType winningType = WinningType.getWinningType(matchCount);
		assertThat(winningType.name()).isEqualTo(expect);
	}
}