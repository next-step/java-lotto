package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;

    private final List<LottoNumber> lottoNumberList;

    public LottoTicket(List<Integer> lottoNumberList) {
        validateSize(lottoNumberList);
        validateDuplicate(lottoNumberList);
        this.lottoNumberList = LottoNumber.convertToLottoNumberList(lottoNumberList);
    }

    private void validateSize(List<Integer> lottoNumberList) {
        if (lottoNumberList.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> lottoNumberList) {
        Set<Integer> validateSet = new HashSet<>(lottoNumberList);

        if (validateSet.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LottoExceptionMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    public WinningCondition getWinningCondition(List<LottoNumber> winningNumbers) {
        return new WinningCondition((int) lottoNumberList.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumberList, that.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }

    @Override
    public String toString() {
        return lottoNumberList.toString();
    }
}
