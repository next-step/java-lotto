package com.hskim.lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoWinningTicket {

    private final List<LottoNumber> winningNumberList;
    private final BonusNumber bonusNumber;

    public LottoWinningTicket(List<Integer> winningNumberList, int bonusNumber) {
        this.winningNumberList = LottoNumber.convertToLottoNumberList(winningNumberList);
        this.bonusNumber = new BonusNumber(bonusNumber, this.winningNumberList);
    }

    public WinningCondition getWinningCondition(List<LottoNumber> lottoNumbers) {
        int matchingNumber = (int) lottoNumbers.stream()
                .filter(winningNumberList::contains)
                .count();

        boolean isMatchingBonusBall = lottoNumbers.contains(bonusNumber.getBonusNumber());
        return new WinningCondition(matchingNumber, isMatchingBonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoWinningTicket)) return false;
        LottoWinningTicket that = (LottoWinningTicket) o;
        return Objects.equals(winningNumberList, that.winningNumberList) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumberList, bonusNumber);
    }
}
