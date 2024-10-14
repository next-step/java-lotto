package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.result.Rank;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.InvalidSizeOfLottoException;
import lotto.exception.UnsortedLottoNumbersException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int SIZE_OF_LOTTO = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        checkSizeOfLottoNumbers(lottoNumbers);
        checkIfSorted(lottoNumbers);
        checkIfDuplicateExists(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    private boolean isInvalidSizeOfLotto(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != SIZE_OF_LOTTO;
    }

    private void checkSizeOfLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (isInvalidSizeOfLotto(lottoNumbers)) {
            throw new InvalidSizeOfLottoException("로또 번호 갯수 오류입니다.");
        }
    }

    private static void checkIfDuplicateExists(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        if (uniqueLottoNumbers.size() != lottoNumbers.size()) {
            throw new DuplicateLottoNumberException("중복된 로또 번호가 존재합니다.");
        }
    }

    private void checkIfSorted(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> sortedLottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());

        if (!sortedLottoNumbers.equals(lottoNumbers)) {
            throw new UnsortedLottoNumbersException("로또 번호는 정렬된 상태여야 합니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (LottoNumber lottoNumber : lottoNumbers) {
            builder.append(lottoNumber.toString()).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }

    public boolean match(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Rank match(WinningLotto winningLotto) {
        long matchCount = lottoNumbers.stream()
                .filter(winningLotto::winningMatch)
                .count();
        return Rank.of(matchCount);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
