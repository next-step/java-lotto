package dev.dahye.lotto.domain;

import java.util.*;

public class LottoTicket {
    private static final int LOTTO_TICKET_NUMBER_MAX_SIZE = 6;
    private static final int ZERO_VALUE = 0;

    private final List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers) {
        validateLottoNumberIsNotNull(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;

        validateLottoNumberRange();
        validateLottoNumberSize();
        validateDuplicateNumbers();
    }

    private void validateLottoNumberIsNotNull(List<Integer> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("lottoNumbers는 null일 수 없습니다.");
        }
    }

    public static LottoTicket autoIssued() {
        return new LottoTicket(LottoNumberMaker.createShuffled(LOTTO_TICKET_NUMBER_MAX_SIZE));
    }

    public static List<LottoTicket> autoIssued(int countOfLotto) {
        validateCountOfLotto(countOfLotto);
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            lottoTickets.add(LottoTicket.autoIssued());
        }

        return lottoTickets;
    }

    private static void validateCountOfLotto(int countOfLotto) {
        if(countOfLotto <= ZERO_VALUE) {
            throw new IllegalArgumentException("로또 티켓 생성 갯수가 유효하지 않습니다.");
        }
    }

    public static LottoTicket manualIssued(List<Integer> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    private void validateLottoNumberSize() {
        if (lottoNumbers.size() != LOTTO_TICKET_NUMBER_MAX_SIZE) {
            throw new IllegalArgumentException("로또 티켓은 6자리 숫자여야 합니다.");
        }
    }

    private void validateLottoNumberRange() {
        for (Integer lottoNumber : this.lottoNumbers) {
            LottoNumbers.validNumberRange(lottoNumber);
        }
    }

    private void validateDuplicateNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>(this.lottoNumbers);
        if (lottoNumbers.size() != LOTTO_TICKET_NUMBER_MAX_SIZE) {
            throw new IllegalArgumentException("로또 티켓에는 중복된 숫자가 없어야 합니다.");
        }
    }

    public int getCountOfMatch(LottoTicket winningTicket) {
        int countOfMatch = 0;

        for (Integer winningNumber : winningTicket.lottoNumbers) {
            countOfMatch = getCountOfMatchWhenContainsNumber(countOfMatch, winningNumber);
        }

        return countOfMatch;
    }

    private int getCountOfMatchWhenContainsNumber(int countOfMatch, Integer winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            countOfMatch++;
        }
        return countOfMatch;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
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

    public boolean contains(int bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }
}
