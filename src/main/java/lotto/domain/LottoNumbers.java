package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    protected static final List<Integer> LOTTO_NUMBERS = initNumbers();

    private LottoNumbers() {
        throw new IllegalStateException("인스턴스를 생성할 수 없는 클래스입니다.");
    }

    private static List<Integer> initNumbers() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            nums.add(i + 1);
        }
        return nums;
    }

    public static List<Integer> shuffleLottoNumbers() {
        List<Integer> shuffled = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(shuffled);
        return shuffled.subList(0, 6);
    }
}
