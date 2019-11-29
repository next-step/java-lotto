package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.LOTTO_SIZE;

public class LottoTicket {
    public static final int LOTTO_PRICE = 1000;
    private static final String LOTTO_NUMS_DELIMITER = ",";

    private Set<LottoNum> lottoNums;

    private LottoTicket(List<Integer> lottoNums) {
        this.lottoNums = LottoGenerator.makeNumbers(lottoNums);
    }

    public static LottoTicket of(List<Integer> lottoNums) {
        return new LottoTicket(lottoNums);
    }

    public static LottoTicket ofString(String manualLotto) {
        List<Integer> lottoNums = splitNums(manualLotto);
        return new LottoTicket(lottoNums);
    }

    public static List<Integer> splitNums(String lottoInput) {
        String[] splitedNums = lottoInput.split(LOTTO_NUMS_DELIMITER);

        int numSize = splitedNums.length;

        Set<Integer> lotto = new HashSet<>();

        for (int i = 0; i < numSize; i++) {
            lotto.add(Integer.parseInt(splitedNums[i].trim()));
        }

        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 서로 다른 6개를 입력해야 합니다.");
        }

        return new ArrayList<>(lotto);
    }

    public int countMatchNumber(Set<LottoNum> winnerNums) {
        long countOfMatchNumber = this.lottoNums.stream()
                .filter(winnerNums::contains)
                .count();

        return Math.toIntExact(countOfMatchNumber);
    }

    public boolean matchNumber(LottoNum lottoNum) {
        return lottoNums.contains(lottoNum);
    }

    public Set<LottoNum> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return String.join(LOTTO_NUMS_DELIMITER, String.valueOf(lottoNums.stream().map(LottoNum::getLottoNum).collect(Collectors.toList())));
    }
}
