package study.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> winningNumbers;

    private WinningLotto(List<LottoNumber> winningNumbers) {
        if(winningNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성 되어야 합니다.");
        }

        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(String[] winningNumbers) {
        List<LottoNumber> winningNumberList = Arrays.stream(winningNumbers)
                                                .map(Integer::parseInt)
                                                .map(LottoNumber::new)
                                                .collect(Collectors.toList());

        return new WinningLotto(winningNumberList);
    }

    public List<LottoNumber> getLottoNumbers() {
        return winningNumbers;
    }
}
