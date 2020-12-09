package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidLottoTicketException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int LOTTO_TICKET_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);

        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static LottoTicket of(LottoTicketCreatePolicy createPolicy) {
        return createPolicy.create();
    }

    public int howManyMatch(LottoTicket thatTicket) {
        List<LottoNumber> matchedNumbers = lottoNumbers.stream()
                .filter(thatTicket::isContains)
                .collect(Collectors.toList());
        return matchedNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    int size() {
        return this.lottoNumbers.size();
    }

    private boolean isContains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> dupRemovedLottoNumbers = new HashSet<>(lottoNumbers);

        if (dupRemovedLottoNumbers.size() != LOTTO_TICKET_SIZE) {
            throw new InvalidLottoTicketException("LottoTicket은 중복 없이 6개의 LottoNumber로만 이루어져야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return this.lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
