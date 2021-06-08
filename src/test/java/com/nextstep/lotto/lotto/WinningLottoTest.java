package com.nextstep.lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nextstep.lotto.result.LottoRank;

public class WinningLottoTest {

	Set<LottoNumber> winningNumbers = new HashSet<>();
	Lotto lotto;

	@BeforeEach
	void setUp() {
		winningNumbers.add(new LottoNumber(1));
		winningNumbers.add(new LottoNumber(2));
		winningNumbers.add(new LottoNumber(3));
		winningNumbers.add(new LottoNumber(4));
		winningNumbers.add(new LottoNumber(5));
		winningNumbers.add(new LottoNumber(6));

		lotto = new Lotto(winningNumbers);
	}

	@Test
	void create() {
		WinningLotto winningLotto = new WinningLotto(lotto);
		assertThat(winningLotto).isNotNull();
	}

	@Test
	void 당첨번호와_비교해서_6개_매칭() {
		WinningLotto winningLotto = new WinningLotto(lotto);

		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(6));
		Lotto lotto = new Lotto(lottoNumbers);

		assertThat(winningLotto.matchRank(lotto)).isEqualTo(LottoRank.FIRST_RANK);
	}

	@Test
	void 당첨번호와_비교해서_5개_매칭() {
		WinningLotto winningLotto = new WinningLotto(lotto);

		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(7));
		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(winningLotto.matchRank(lotto)).isEqualTo(LottoRank.THIRD_RANK);
	}

	@Test
	void 당첨번호와_비교해서_4개_매칭() {
		WinningLotto winningLotto = new WinningLotto(lotto);

		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(7));
		lottoNumbers.add(new LottoNumber(8));
		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(winningLotto.matchRank(lotto)).isEqualTo(LottoRank.FOURTH_RANK);
	}

	@Test
	void 당첨번호와_비교해서_3개_매칭() {
		WinningLotto winningLotto = new WinningLotto(lotto);

		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(7));
		lottoNumbers.add(new LottoNumber(8));
		lottoNumbers.add(new LottoNumber(9));
		Lotto lotto = new Lotto(lottoNumbers);
		assertThat(winningLotto.matchRank(lotto)).isEqualTo(LottoRank.FIFTH_RANK);
	}
}
