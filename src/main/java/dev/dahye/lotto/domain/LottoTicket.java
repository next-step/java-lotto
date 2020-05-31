package dev.dahye.lotto.domain;

import java.util.*;

import static java.util.Collections.shuffle;

public class LottoTicket {
    private static final int LOTTO_TICKET_NUMBER_MIN_SIZE = 0;
    private static final int LOTTO_TICKET_NUMBER_MAX_SIZE = 6;
    private final List<Integer> lottoNumbers;

    public LottoTicket(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

        validateLottoNumberSize();
        validateDuplicateNumbers();
    }

    public static LottoTicket issued() {
        return new LottoTicket(createLottoNumbers());
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> numbers = LottoNumber.getNumbers();
        shuffle(numbers);


        return new ArrayList<>(numbers.subList(LOTTO_TICKET_NUMBER_MIN_SIZE, LOTTO_TICKET_NUMBER_MAX_SIZE));
    }

    protected boolean validateLottoNumberSize() {
        return lottoNumbers.size() == LOTTO_TICKET_NUMBER_MAX_SIZE;
    }

    protected boolean validateDuplicateNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>(this.lottoNumbers);
        return lottoNumbers.size() == LOTTO_TICKET_NUMBER_MAX_SIZE;
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        int matchCount = 0;

        for (Integer winningNumber : winningNumbers) {
            matchCount = getMatchCount(matchCount, winningNumber);
        }

        return matchCount;
    }

    private int getMatchCount(int matchCount, Integer winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            matchCount++;
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers.toArray());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
