package lottoAuto.model;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    private static final String SPLIT_WINNING_LOTTO = ",";

    public static Lotto splitWinningNumber(String winningLottoNumber) {
        List<Integer> lottoNumbers = new ArrayList<>();

        String[] splitedWinningNumbers = winningLottoNumber.split(SPLIT_WINNING_LOTTO);
        for (int i = 0; i < splitedWinningNumbers.length; i++) {
            lottoNumbers.add(Integer.valueOf(splitedWinningNumbers[i]));
        }
        return new Lotto(lottoNumbers);
    }
}
