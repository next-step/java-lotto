package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    public static final int LOTTO_PRICE = 1000;
    private static final LottoCandidate candidateNumbers = new LottoCandidate();
    private static final String LOTTO_NUMS_DELIMITER = ",";

    private List<LottoNum> lottoNums;

    public LottoTicket() {
        candidateNumbers.shuffle();

        this.lottoNums = makeAutoNumbers();
    }

    public LottoTicket(List<Integer> lottoNums) {
        candidateNumbers.shuffle();

        this.lottoNums = makeNumbers(lottoNums);
    }

    public List<LottoNum> makeNumbers(List<Integer> lottoNums) {
        List<LottoNum> selectedNums = new ArrayList<>();

        for (int inputLottoNum : lottoNums) {
            LottoNum lottoNum = new LottoNum(inputLottoNum);
            selectedNums.add(lottoNum);
        }

        Collections.sort(selectedNums);

        return selectedNums;
    }

    public List<LottoNum> makeAutoNumbers() {
        List<LottoNum> selectedNums;

        selectedNums = candidateNumbers.addRandomNumber();

        Collections.sort(selectedNums);

        return selectedNums;
    }

    public int countMatchNumber(List<Integer> winnerNums) {
        long countOfMatchNumber = this.lottoNums.stream()
                .map(LottoNum::getLottoNum)
                .filter(winnerNums::contains)
                .count();

        return Math.toIntExact(countOfMatchNumber);
    }

    public int size() {
        return lottoNums.size();
    }

    public boolean contains(int inputNumber) {
        return lottoNums.stream()
            .map(LottoNum::getLottoNum)
            .anyMatch(number -> number == inputNumber);
    }

    @Override
    public String toString() {
        return String.join(LOTTO_NUMS_DELIMITER, String.valueOf(lottoNums));
    }

}
