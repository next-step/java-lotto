package com.nextstep.lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	void create() {
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
		assertThat(lotto).isNotNull();
	}

	@Test
	void 숫자개수가_6개가_아니면_exception() {
		assertThatThrownBy(() ->
			new Lotto(new LottoNumberGenerator() {
				@Override
				public List<LottoNumber> makeRandomNumbers() {
					List<LottoNumber> list = new ArrayList<>();
					list.add(new LottoNumber(1));
					list.add(new LottoNumber(2));
					list.add(new LottoNumber(3));
					list.add(new LottoNumber(4));
					list.add(new LottoNumber(5));
					return list;
				}
			})
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 중복된_숫자가_들어오면_exception() {
		assertThatThrownBy(() ->
			new Lotto(new LottoNumberGenerator() {
				@Override
				public List<LottoNumber> makeRandomNumbers() {
					List<LottoNumber> list = new ArrayList<>();
					list.add(new LottoNumber(1));
					list.add(new LottoNumber(2));
					list.add(new LottoNumber(3));
					list.add(new LottoNumber(4));
					list.add(new LottoNumber(5));
					list.add(new LottoNumber(5));
					return list;
				}
			})
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 매칭되는_숫자_개수_6개() {
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
		Set<LottoNumber> list = new HashSet<>();
		list.add(new LottoNumber(1));
		list.add(new LottoNumber(2));
		list.add(new LottoNumber(3));
		list.add(new LottoNumber(4));
		list.add(new LottoNumber(5));
		list.add(new LottoNumber(6));

		assertThat(lotto.matchCount(list)).isEqualTo(6);
	}

	@Test
	void 매칭되는_숫자_개수_5개() {
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
		Set<LottoNumber> list = new HashSet<>();
		list.add(new LottoNumber(1));
		list.add(new LottoNumber(2));
		list.add(new LottoNumber(3));
		list.add(new LottoNumber(4));
		list.add(new LottoNumber(5));
		list.add(new LottoNumber(6));
		assertThat(lotto.matchCount(list)).isEqualTo(5);
	}
}
