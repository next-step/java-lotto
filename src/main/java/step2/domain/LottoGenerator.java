package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static List<LottoNum> makeNumbers(List<Integer> lottoNums) {
        List<LottoNum> selectedNums = new ArrayList<>();

        for (int inputLottoNum : lottoNums) {
            LottoNum lottoNum = new LottoNum(inputLottoNum);
            selectedNums.add(lottoNum);
        }

        Collections.sort(selectedNums);

        return selectedNums;
    }

    public static List<LottoNum> makeAutoNumbers(LottoCandidate candidateNumbers) {
        List<LottoNum> selectedNums;

        selectedNums = candidateNumbers.addRandomNumber();

        Collections.sort(selectedNums);

        return selectedNums;
    }
}
