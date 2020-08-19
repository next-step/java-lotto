package com.hskim.lotto.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    public static List<LottoTicket> automaticIssuance(PurchasePrice purchasePrice, LottoNumberMaker numberMaker) {
        GameNumber gameNumber = purchasePrice.getGameNum();
        List<LottoTicket> result = new LinkedList<>();
        while (gameNumber.isPlayable()) {
            List<Integer> lottoNumbers = numberMaker.makeNumbers(LottoTicket.LOTTO_NUMBERS_SIZE);
            result.add(new LottoTicket(lottoNumbers));
            gameNumber.playGame();
        }

        return result;
    }

    public static List<LottoTicket> manualIssuance(List<List<Integer>> lottoNumbersList) {
        return lottoNumbersList.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }
}
