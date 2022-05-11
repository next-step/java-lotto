package study.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumbers {
    static final int LOTTO_BEGIN_NUMBER = 1;
    static final int LOTTO_END_NUMBER = 45;

    static final List<Integer> lottoNumbers = new ArrayList<>(); // static 역할을 위해 private 제거

    public LottoNumbers() {
        IntStream.rangeClosed(LOTTO_BEGIN_NUMBER, LOTTO_END_NUMBER).forEach(lottoNumbers::add);
        if (isInvalid()) {
            throw new IllegalArgumentException("로또번호가 잘못 생성되었습니다. 시스템 관리자에게 문의해주세요.");
        }
    }

    private boolean isInvalid() {
        for (int idx = LOTTO_BEGIN_NUMBER; idx <= LOTTO_END_NUMBER; idx++) {
            if (!lottoNumbers.contains(idx)) {
                return true;
            }
        }
        return false;
    }
}