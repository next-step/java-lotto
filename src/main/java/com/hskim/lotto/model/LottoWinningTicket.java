package com.hskim.lotto.model;

import java.util.List;
import java.util.Optional;

public class LottoWinningTicket {

    private final List<LottoNumber> winningNumberList;

    public LottoWinningTicket(List<Integer> winningNumberList) {
        this.winningNumberList = LottoNumber.convertToLottoNumberList(winningNumberList);
    }

    public Optional<LottoWinTable> findWinnerTable(LottoTicket lottoTicket) {
        return LottoWinTable.find(lottoTicket.getWinningCondition(winningNumberList));
    }
}
