package domain;

import java.util.Comparator;

public class LottoNumberComparator implements Comparator<LottoNumber> {
    @Override
    public int compare(LottoNumber o1, LottoNumber o2) {
        return o1.getLottoNumber() - o2.getLottoNumber();
    }
}