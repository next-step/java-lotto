package Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoList {

    private List<Lotto> list = new ArrayList<>();

    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_LAST_NUMBER = 6;

    public LottoList() {
    }

    public List<Lotto> createLottoNumbers(int lottoCount) {
        List<Integer> tmpNumbers = new ArrayList<>();
        createAllNumbers(tmpNumbers);

        for (int i = 0; i < lottoCount; ++i) {
            pickLottoNumbers(tmpNumbers);
        }

        return list;
    }

    private void createAllNumbers(List<Integer> tmpNumbers) {
        for (int i = 0; i < LOTTO_MAX_NUMBER; ++i) {
            tmpNumbers.add(i+1);
        }
    }

    private void pickLottoNumbers(List<Integer> tmpNumbers) {
        int[] lottoNumbers = new int[LOTTO_LAST_NUMBER];

        Collections.shuffle(tmpNumbers);
        for (int j = 0; j < LOTTO_LAST_NUMBER; ++j) {
            lottoNumbers[j] = tmpNumbers.get(j);
        }

        Arrays.sort(lottoNumbers);

        list.add(new Lotto(lottoNumbers));
    }
}
