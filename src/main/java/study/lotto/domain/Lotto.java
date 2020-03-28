package study.lotto.domain;

import java.util.*;

public class Lotto {
    public static final int PRICE = 1000;
    private static final int LOTTO_NUMBER_TOTAL = 6;
    private Set<LottoNumber> lotto;

    public Lotto(int[] lottoNumbers) {
        if (Objects.isNull(lottoNumbers) ||
                lottoNumbers.length != LOTTO_NUMBER_TOTAL) {
            throw new IllegalArgumentException("6개의 로또 숫자를 입력하세요.");
        }

        setLotto(lottoNumbers);
        if (lotto.size() != LOTTO_NUMBER_TOTAL) {
            throw new IllegalArgumentException("중복된 숫자가 없어야 합니다.");
        }
    }

    public int size() {
        return lotto.size();
    }

    private void setLotto(int[] lottoNumbers) {
        lotto = new HashSet<>();
        for (int number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }
    }
}
