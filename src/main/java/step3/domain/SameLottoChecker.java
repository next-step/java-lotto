package step3.domain;

import java.util.Set;

public class SameLottoChecker {

    private static final int BASE_NUMBER = 0;

    public static int countSameLottoNumber(Lotto l1, Lotto l2) {
        int count = BASE_NUMBER;

        Set<LottoNumber> anotherLotto = l2.getLottoNumbers();
        for (LottoNumber another : anotherLotto) {
            count = calculateCount(l1, count, another);
        }
        return count;
    }

    private static int calculateCount(Lotto l1, int count, LottoNumber another) {
        if (l1.findLottoNum(another)) {
            count++;
        }
        return count;
    }
}
