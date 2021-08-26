package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

	List<LottoNumber> createNumbers(List<Integer> numbers) {
		return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}

	@Test
	@DisplayName("동일한 숫자에 몇개 있는지를 통해서 로또 결과 확인")
	void compare() {
		LottoNumbers winningNumber = new LottoNumbers(createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
		LottoNumbers lotto1 = new LottoNumbers(createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

		assertThat(LottoRank.findLottoRank(lotto1, winningNumber)).isEqualTo(LottoRank.FIRST);

		LottoNumbers lotto2 = new LottoNumbers(createNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)));

		assertThat(LottoRank.findLottoRank(lotto2, winningNumber)).isEqualTo(LottoRank.SECOND);

		LottoNumbers lotto3 = new LottoNumbers(createNumbers(Arrays.asList(1, 2, 3, 4, 7, 8)));

		assertThat(LottoRank.findLottoRank(lotto3, winningNumber)).isEqualTo(LottoRank.THIRD);

		LottoNumbers lotto4 = new LottoNumbers(createNumbers(Arrays.asList(1, 2, 3, 7, 8, 9)));

		assertThat(LottoRank.findLottoRank(lotto4, winningNumber)).isEqualTo(LottoRank.FOURTH);

		LottoNumbers lotto5 = new LottoNumbers(createNumbers(Arrays.asList(1, 2, 7, 8, 9, 10)));

		assertThat(LottoRank.findLottoRank(lotto5, winningNumber)).isEqualTo(LottoRank.NOTHING);
	}
}
