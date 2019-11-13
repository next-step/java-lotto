package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_PRICE = 1000;
    private static final String LOTTO_NUMS_DELIMITER = ",";

    private List<LottoNum> lottoNums;

    public LottoTicket() {
        this.lottoNums = LottoGenerator.makeAutoNumbers();
    }

    public LottoTicket(List<Integer> lottoNums) {
        this.lottoNums = LottoGenerator.makeNumbers(lottoNums);
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
        return String.join(LOTTO_NUMS_DELIMITER, String.valueOf(lottoNums.stream().map(LottoNum::getLottoNum).collect(Collectors.toList())));
    }

}
