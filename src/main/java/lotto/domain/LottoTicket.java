package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.LOTTO_SIZE;

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

    public static LottoTicket ofString(String manualLotto) {
        List<Integer> lotto = splitNums(manualLotto);
        return new LottoTicket(lotto);
    }

    public static List<Integer> splitNums(String lottoInput) {
        String[] splitedNums = lottoInput.split(LOTTO_NUMS_DELIMITER);

        int numSize = splitedNums.length;

        if(numSize != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개를 입력해야 합니다.");
        }

        List<Integer> lotto = new ArrayList<>();

        for (int i = 0; i < numSize; i++) {
            lotto.add(Integer.parseInt(splitedNums[i].trim()));
        }

        return lotto;
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
