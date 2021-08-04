package lotto.utils;

import java.util.Comparator;

import lotto.model.Prize;

public class PrizeComparator implements Comparator<Prize> {
	@Override
	public int compare(Prize o1, Prize o2) {
		return Integer.compare(o1.getWinningMoney(), o2.getWinningMoney());
	}
}
