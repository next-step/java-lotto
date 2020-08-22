package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LottoTicket {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        lottoNumberRangeValidation(lottoNumbers);
        lottoNumberDuplicatedValidate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void lottoNumberRangeValidation(List<Integer> lottoNumbers) {
        Optional<Integer> wrongNumber = lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber < MINIMUM_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER)
                .findFirst();

        if (wrongNumber.isPresent()) {
            throw new IllegalArgumentException("잘못된 로또 번호입니다.");
        }
    }

    private void lottoNumberDuplicatedValidate(List<Integer> lottoNumbers) {
        Set<Integer> collector = new HashSet<>();
        lottoNumbers.forEach(number -> {
            if (collector.contains(number)) {
                throw new IllegalArgumentException("중복된 번호가 존재합니다.");
            }

            collector.add(number);
        });
    }

    public int matchNumbers(List<Integer> lastWeekWinningNumbers) {
        int matchCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            matchCount += matchNumber(lastWeekWinningNumbers, lottoNumber);
        }

        return matchCount;
    }

    private int matchNumber(List<Integer> lastWeekWinningNumbers, Integer lottoNumber) {
        if (lastWeekWinningNumbers.contains(lottoNumber)) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}