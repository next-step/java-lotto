package com.nextstep.lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.nextstep.lotto.result.LottoRank;

public class WinningLottoTest {

	@Test
	void create() {
		List<LottoNumber> list = new ArrayList<>();
		list.add(new LottoNumber(1));
		list.add(new LottoNumber(2));
		list.add(new LottoNumber(3));
		list.add(new LottoNumber(4));
		list.add(new LottoNumber(5));
		list.add(new LottoNumber(6));
		WinningLotto winningLotto = new WinningLotto(list);
		assertThat(winningLotto).isNotNull();
	}

	@Test
	void 당첨번호와_비교해서_몇개의_숫자가_매칭되는지() {
		List<LottoNumber> list = new ArrayList<>();
		list.add(new LottoNumber(1));
		list.add(new LottoNumber(2));
		list.add(new LottoNumber(3));
		list.add(new LottoNumber(4));
		list.add(new LottoNumber(5));
		list.add(new LottoNumber(6));
		WinningLotto winningLotto = new WinningLotto(list);
		Lotto lotto = new Lotto(new LottoNumberGenerator() {
			@Override
			public List<LottoNumber> makeRandomNumbers() {
				List<LottoNumber> list = new ArrayList<>();
				list.add(new LottoNumber(1));
				list.add(new LottoNumber(2));
				list.add(new LottoNumber(3));
				list.add(new LottoNumber(4));
				list.add(new LottoNumber(5));
				list.add(new LottoNumber(6));
				return list;
			}
		});
		System.out.println(lotto);
		assertThat(winningLotto.matchRank(lotto)).isEqualTo(LottoRank.FIRST_RANK);
	}

	@Test
	void 당첨번호와_비교해서_5개_매칭() {
		List<LottoNumber> list = new ArrayList<>();
		list.add(new LottoNumber(1));
		list.add(new LottoNumber(2));
		list.add(new LottoNumber(3));
		list.add(new LottoNumber(4));
		list.add(new LottoNumber(5));
		list.add(new LottoNumber(6));
		WinningLotto winningLotto = new WinningLotto(list);
		Lotto lotto = new Lotto(new LottoNumberGenerator() {
			@Override
			public List<LottoNumber> makeRandomNumbers() {
				List<LottoNumber> list = new ArrayList<>();
				list.add(new LottoNumber(1));
				list.add(new LottoNumber(2));
				list.add(new LottoNumber(3));
				list.add(new LottoNumber(4));
				list.add(new LottoNumber(5));
				list.add(new LottoNumber(7));
				return list;
			}
		});
		assertThat(winningLotto.matchRank(lotto)).isEqualTo(LottoRank.THIRD_RANK);
	}
}
