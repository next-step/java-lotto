package lotto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int MINIMUM_OVERLAP_COUNT = 2;
    private static final int DEFAULT_SIZE = 6;

    private List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateElements(lottoNumbers);
        validateOverlap(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<Integer> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void sort() {
        lottoNumbers.sort(Integer::compareTo);
    }

    public boolean contains(Integer number){
        return lottoNumbers.contains(number);
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() < DEFAULT_SIZE) {
            throw new IllegalArgumentException("당첨 번호의 개수가 알맞지 않습니다.");
        }
    }

    private void validateElements(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            checkNumber(lottoNumbers.get(i));
        }
    }

    private void checkNumber(int number){
        if (number < LottoNumber.LOTTO_NUMBER_MIN || number > LottoNumber.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("당첨 번호의 범위가 알맞지 않습니다.");
        }
    }

    private void validateOverlap(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().forEach(this::checkOverlapCount);
    }

    private void checkOverlapCount(Long count) {
        if (count >= MINIMUM_OVERLAP_COUNT) {
            throw new IllegalArgumentException("중복 되는 값이 존재합니다.");
        }
    }
}
