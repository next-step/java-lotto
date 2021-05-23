package step3.domain;

import step3.domain.Lotto;

public class SameLottoChecker {


    private static int left, right;
    private static int count;

    public static int countSameLottoNum(Lotto l1, Lotto l2) {
        count = 0;
        left = 0;
        right = 0;
        l1.sort();
        l2.sort();

        while (left < l1.length() && right < l2.length()) {
            findCount(l1, l2);
        }

        return count;
    }

    private static void findCount(Lotto l1, Lotto l2) {
        if (left < 6 && l1.findLottoNumByIdx(left) < l2.findLottoNumByIdx(right)) {
            left++;
        }

        if (right < 6 && l1.findLottoNumByIdx(left) > l2.findLottoNumByIdx(right)) {
            right++;
        }

        if (left < 6 && right < 6 && l1.findLottoNumByIdx(left).equals(l2.findLottoNumByIdx(right))) {
            left++;
            right++;
            count++;
        }
    }
}
