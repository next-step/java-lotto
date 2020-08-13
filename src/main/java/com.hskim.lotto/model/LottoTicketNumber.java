package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoTicketNumber {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<String> lottoNumberList;

    public LottoTicketNumber(List<String> lottoNumberList) {

        validateSize(lottoNumberList);
        validateDuplicate(lottoNumberList);
        this.lottoNumberList = lottoNumberList;
    }

    private void validateSize(List<String> lottoNumberList) {

        if(lottoNumberList.size() != LOTTO_NUMBERS_SIZE) {

            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<String> lottoNumberList) {

        Set<String> validateSet = new HashSet<>(lottoNumberList);

        if(validateSet.size() != LOTTO_NUMBERS_SIZE) {

            throw new IllegalArgumentException(LottoExceptionMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicketNumber)) return false;
        LottoTicketNumber that = (LottoTicketNumber) o;
        return Objects.equals(lottoNumberList, that.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }
}
