package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {
	@Test
	@DisplayName("동일한 숫자에 몇개 있는지를 통해서 로또 결과 확인")
	void compare() {

		assertThat(LottoRank.findLottoRank(6, false)).isEqualTo(LottoRank.FIRST);

		assertThat(LottoRank.findLottoRank(5, true)).isEqualTo(LottoRank.SECOND);

		assertThat(LottoRank.findLottoRank(5, false)).isEqualTo(LottoRank.THIRD);

		assertThat(LottoRank.findLottoRank(4, false)).isEqualTo(LottoRank.FOURTH);

		assertThat(LottoRank.findLottoRank(3, false)).isEqualTo(LottoRank.FIFTH);

		assertThat(LottoRank.findLottoRank(2, false)).isEqualTo(LottoRank.NOTHING);
	}
}
