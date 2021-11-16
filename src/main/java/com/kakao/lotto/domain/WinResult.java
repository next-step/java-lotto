package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.PurchaseInfo;
import com.kakao.lotto.supportInfo.WinLottoInfo;

import java.util.Arrays;
import java.util.List;

public class WinResult {
    private final List<LottoTicket> userLottoTicket;
    private final WinLottoTicket winLottoTicket;

    public WinResult(List<LottoTicket> userLottoTicket, WinLottoInfo winLottoInfo) {
        this.userLottoTicket = userLottoTicket;
        this.winLottoTicket = WinLottoTicket.of(winLottoInfo.getWinLottoNumbers());
    }

    public double calculateProfitRate(PurchaseInfo purchaseInfo) {
        Integer profit = userLottoTicket.stream()
                .map(winLottoTicket::matchWinNumber)
                .map(LottoRank::findByMatchRank)
                .map(LottoRank::getPrice)
                .reduce(0, Integer::sum);
        return profitFormula(purchaseInfo.getMoney(), profit);
    }

    private double profitFormula(int beforeMoney, int nowMoney) {
        return (double) nowMoney / beforeMoney;
    }

    public int getLottoRankCount(LottoRank lottoRank) {
        return (int) userLottoTicket.stream()
                .map(winLottoTicket::matchWinNumber)
                .map(LottoRank::findByMatchRank)
                .filter(rank -> lottoRank == rank)
                .count();
    }


}
