package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCollectionTest {

	static class AlwaysReturn_1_2_3_4_5_6 extends RandomGenerator {

		@Override
		public List<Integer> generate() {
			return Arrays.asList(1, 2, 3, 4, 5, 6);
		}
	}


	@Test
	void match() {
		LottoCollection lottoCollection = new LottoCollection(1, new AlwaysReturn_1_2_3_4_5_6());

		List<LottoRank> lottoRanks = lottoCollection.lottoRanks(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));

		assertThat(lottoRanks).hasSize(1)
				.contains(LottoRank.FIRST);
	}

}