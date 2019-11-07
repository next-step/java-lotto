package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;
    private static final LottoCandidate candidateNumbers = new LottoCandidate();
    private static final String LOTTO_NUMS_DELIMITER = ",";

    private List<Integer> lottoNums;

    public LottoTicket() {
        candidateNumbers.shuffle();

        this.lottoNums = makeAutoNumbers();
        checkNumsRange();
    }

    public LottoTicket(List<Integer> lottoNums) {
        candidateNumbers.shuffle();

        this.lottoNums = lottoNums;
        checkNumsRange();
    }

    public List<Integer> makeAutoNumbers() {
        List<Integer> selectedNums = new ArrayList<>();

        candidateNumbers.addRandomNumber(selectedNums);

        Collections.sort(selectedNums);

        return selectedNums;
    }

    private void checkNumsRange() {
        for (int lottoNum : lottoNums) {
            checkNumRange(lottoNum);
        }
    }

    public static void checkNumRange(int lottoNum) {
        if (!isProperNumRange(lottoNum)) {
            throw new IllegalArgumentException("Out of range");
        }
    }

    private static boolean isProperNumRange(int lottoNum) {
        return lottoNum >= LOTTO_NUM_MIN && lottoNum <= LOTTO_NUM_MAX;
    }

    public int matchNumber(List<Integer> winnerNums) {
        Long matchNumber = this.lottoNums.stream()
                .filter(winnerNums::contains)
                .count();

        return Math.toIntExact(matchNumber);
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    public int size() {
        return lottoNums.size();
    }

    public boolean contains(int number) {
        return lottoNums.contains(number);
    }

    @Override
    public String toString() {
        return String.join(LOTTO_NUMS_DELIMITER, String.valueOf(lottoNums));
    }

}
