package lottoAuto.model;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {
    private static final String SPLIT_WINNING_LOTTO = ",";

    public static Lotto makeLotto(String winningLottoNumber) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        String[] splitedWinningNumbers = winningLottoNumber.split(SPLIT_WINNING_LOTTO);
        for (int i = 0; i < splitedWinningNumbers.length; i++) {
            lottoNumbers.add(new LottoNumber(Integer.valueOf(splitedWinningNumbers[i])));
        }
        return new Lotto(lottoNumbers);
    }
}
