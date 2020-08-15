package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;

import java.util.List;
import java.util.Optional;

public class LottoWinningTicket extends LottoTicket {

    private final List<String> winningNumberList;

    public LottoWinningTicket(List<String> winningNumberList) {
        super(winningNumberList);
        this.winningNumberList = winningNumberList;
    }

    public Optional<LottoWinTable> findWinnerTable(LottoTicket lottoTicket) {
        return LottoWinTable.find(lottoTicket.getWinningCondition(winningNumberList));
    }

    @Override
    public WinningCondition getWinningCondition(List<String> winningNumbers) {
        throw new IllegalStateException(LottoExceptionMessage.ILLEGAL_STATE.getMessage());
    }
}
