package automaticlotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_WINNING_NUMBER = 6;
    private static final String[] lottoNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45"};

    public List<String> getWinningLotto() {
        sortNumber();
        mixingNumber();
        return winningNumber();
    }

    private void sortNumber() {
        Collections.sort(Arrays.asList(lottoNumbers));
    }

    private void mixingNumber() {
        Collections.shuffle(Arrays.asList(lottoNumbers));
    }

    private List<String> winningNumber() {
        List<String> winningNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_WINNING_NUMBER; i++) {
            winningNumbers.add(lottoNumbers[i]);
        }
        return winningNumbers;
    }

}
