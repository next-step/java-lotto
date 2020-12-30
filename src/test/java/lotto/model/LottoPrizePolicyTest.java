package lotto.model;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
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

		Lotto lottoNumber = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),new LottoNumber(4), new LottoNumber(5),new LottoNumber(6)));
		assertThat(LottoPrizePolicy.isMatchBonusNumber(lottoNumber, new LottoNumber(1)).isHasBonusNumber()).isTrue();
		assertThat(LottoPrizePolicy.isMatchBonusNumber(lottoNumber, new LottoNumber(45)).isHasBonusNumber()).isFalse();
	}
}