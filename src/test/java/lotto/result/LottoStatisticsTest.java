package lotto.result;

import lotto.result.LOTTO_RESULT;
import lotto.result.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.TestUtils.duplicate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class LottoStatisticsTest {

	@Test
	@DisplayName("LottoStatistics 를 생성시 전달받은 결과가 비어있을경우 예외 처리 확인")
	void create_empty() {
		// given
		List<LOTTO_RESULT> lottoResultList = Collections.emptyList();

		// when & then
		assertThatThrownBy(() -> LottoStatistics.create(lottoResultList))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("empty");
	}

	@Test
	@DisplayName("LottoStatistics.create() 로 생성되는 객체가 올바른 계산 결과를 갖고 있는지 테스트")
	void create() {
		// given
		List<LOTTO_RESULT> lottoResultList = new ArrayList<>();
		lottoResultList.addAll(duplicate(LOTTO_RESULT.NOTHING, 1));
		lottoResultList.addAll(duplicate(LOTTO_RESULT.MATCHED_THREE, 0));
		lottoResultList.addAll(duplicate(LOTTO_RESULT.MATCHED_FOUR, 3));
		lottoResultList.addAll(duplicate(LOTTO_RESULT.MATCHED_FIVE, 4));
		lottoResultList.addAll(duplicate(LOTTO_RESULT.MATCHED_SIX, 5));

		// when
		LottoStatistics lottoStatistics = LottoStatistics.create(lottoResultList);

		// then
		assertThat(lottoStatistics.getCount(LOTTO_RESULT.NOTHING)).isEqualTo(1);
		assertThat(lottoStatistics.getCount(LOTTO_RESULT.MATCHED_THREE)).isEqualTo(0);
		assertThat(lottoStatistics.getCount(LOTTO_RESULT.MATCHED_FOUR)).isEqualTo(3);
		assertThat(lottoStatistics.getCount(LOTTO_RESULT.MATCHED_FIVE)).isEqualTo(4);
		assertThat(lottoStatistics.getCount(LOTTO_RESULT.MATCHED_SIX)).isEqualTo(5);
	}

	@Test
	@DisplayName("수익률 계산 테스트: 수익 없는 경우")
	void calculateIncomeRate_수익률제로() {
		// given
		List<LOTTO_RESULT> lottoResultList = duplicate(LOTTO_RESULT.NOTHING, 5);
		LottoStatistics lottoStatistics = LottoStatistics.create(lottoResultList);

		// when & then
		assertThat(lottoStatistics.calculateIncomeRate()).isEqualTo(0d);
	}

	@Test
	@DisplayName("수익률 계산 테스트: 수익 있는 경우")
	void calculateIncomeRate_수익률존재() {
		// given
		List<LOTTO_RESULT> lottoResultList = duplicate(LOTTO_RESULT.NOTHING, 5);
		lottoResultList.addAll(duplicate(LOTTO_RESULT.MATCHED_FOUR, 1));
		LottoStatistics lottoStatistics = LottoStatistics.create(lottoResultList);

		// when & then
		assertThat(lottoStatistics.calculateIncomeRate()).isStrictlyBetween(8.30d, 8.39d);
	}
}
