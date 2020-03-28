package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private static final String LOTTO_WINNING_NUMBER_SPLIT_KEYWORD = ",";

    private Lotto winningLotto;

    public WinningLotto(String winningNumbers) {
        this.winningLotto = convertToLotto(winningNumbers);
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    private Lotto convertToLotto(String winningNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String s : winningNumbers.split(LOTTO_WINNING_NUMBER_SPLIT_KEYWORD)) {
            lottoNumbers.add(new LottoNumber(s.trim()));
        }
        return new Lotto(lottoNumbers);
    }
}
