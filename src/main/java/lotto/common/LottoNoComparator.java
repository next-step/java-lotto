package lotto.common;

import lotto.domain.LottoNo;

import java.util.Comparator;

public class LottoNoComparator implements Comparator<LottoNo> {
    @Override
    public int compare(LottoNo first, LottoNo second) {
        int lottoOne = first.lottNo();
        int lottoTwo = second.lottNo();

        if (lottoOne > lottoTwo)
            return 1;
        if (lottoOne < lottoTwo)
            return -1;

        return 0;
    }
}
