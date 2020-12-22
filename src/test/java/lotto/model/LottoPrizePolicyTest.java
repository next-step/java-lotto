package lotto.model;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizePolicyTest {

	@Test
	@DisplayName("최소 매칭 카운트 찾기")
	void getMinMatchCount() {
		assertThat(LottoPrizePolicy.getMinMatchCount()).isEqualTo(LottoPrizePolicy.FIFTH.getMatchCount());
	}

	@Test
	@DisplayName("보너스 번호 매칭 여부")
	void isMatchBonusNumber() {
		Lotto lottoNumber = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
		assertThat(LottoPrizePolicy.isMatchBonusNumber(lottoNumber, 1)).isTrue();
		assertThat(LottoPrizePolicy.isMatchBonusNumber(lottoNumber, 45)).isFalse();
	}
}