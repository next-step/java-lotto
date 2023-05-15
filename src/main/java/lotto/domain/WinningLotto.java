package lotto.domain;

import lotto.domain.number.LottoNumber;
import lotto.util.Util;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {

    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 숫자의 입력값은 6개로 이루어져야 합니다.";
    private static final String SPLIT_REGEX = ", ";
    private final Set<LottoNumber> winningLotto = new HashSet<>();

    public WinningLotto(String input) {
        String[] numbers = input.split(SPLIT_REGEX);
        for (String num : numbers) {
            winningLotto.add(new LottoNumber(Util.convertInt(num)));
        }
        lottoSizeCheck();
    }

    private void lottoSizeCheck() {
        if (winningLotto.size() != LOTTO_SIZE) {
            throw new IllegalStateException(LOTTO_SIZE_ERROR);
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.winningLotto.contains(lottoNumber);
    }
}
