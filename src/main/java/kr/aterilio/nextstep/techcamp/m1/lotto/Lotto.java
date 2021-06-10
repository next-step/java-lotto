package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

    public static final int PRICE_PER_LOTTO = 1000;
    public static final String MSG_PRICE_TAG = "장당 " + PRICE_PER_LOTTO + "원";

    private static final int LOTTO_ELEMENT_COUNT = 6;

    public static final String MSG_ERR_DUPLICATE = "로또를 구성하는 수 중에 중복된 값이 있습니다.";

    private static final String MSG_ERR_REQUIRED_ELEMENT_COUNT = "입력된 요소는 " + LOTTO_ELEMENT_COUNT + "개 여야 합니다.";

    private final Set<LottoBall> lottoBalls;

    public Lotto(Integer[] lottoNumbers) {
        this.lottoBalls = pick(lottoNumbers);
        validateDuplicate();
    }

    public Lotto(List<LottoBall> lottoBalls) {
        this.lottoBalls = new TreeSet<>();
        this.lottoBalls.addAll(lottoBalls);
    }

    public int matchCount(Lotto that) {
        List<LottoBall> matches = new ArrayList<>(this.lottoBalls);
        matches.retainAll(that.lottoBalls);
        return matches.size();
    }

    private Set<LottoBall> pick(Integer[] lottoNumbers) {
        validateElementCount(lottoNumbers);
        Set<LottoBall> lottoBalls = new TreeSet<>();
        for (int i = lottoNumbers.length; i > 0; --i) {
            lottoBalls.add(new LottoBall(lottoNumbers[i-1]));
        }
        return lottoBalls;
    }

    private void validateDuplicate() {
        if (lottoBalls.size() != LOTTO_ELEMENT_COUNT) {
            throw new IllegalArgumentException(MSG_ERR_DUPLICATE);
        }
    }

    private void validateElementCount(Integer[] elements) {
        if (elements.length != LOTTO_ELEMENT_COUNT) {
            throw new IllegalArgumentException(MSG_ERR_REQUIRED_ELEMENT_COUNT);
        }
    }

    public int count() {
        return lottoBalls.size();
    }

    public String join() {
        return lottoBalls.toString();
    }

    public boolean contains(int number) {
        boolean find = false;
        for (LottoBall lottoBall : lottoBalls) {
            find = findOrDefault(lottoBall, number, find);
        }
        return find;
    }

    private boolean findOrDefault(LottoBall lottoBall, int number, boolean find) {
        if (lottoBall.isEqualTo(number)) {
            return true;
        }
        return find;
    }
}
