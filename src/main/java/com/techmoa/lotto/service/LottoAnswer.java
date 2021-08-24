package com.techmoa.lotto.service;

import com.techmoa.lotto.model.LottoResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAnswer {

    private static List<Integer> lottoAnswerNumber = null;
    private static List<LottoResult> LottoResults = new ArrayList<>();

    public LottoAnswer(String enterAnswerString) {
        parseEnterAnswerString(enterAnswerString);
    }

    public void parseEnterAnswerString(String enterAnswerString){
        String[] parseString= enterAnswerString.split(" ");
        this.lottoAnswerNumber=  Arrays.stream(parseString)
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());

    }

    public void result(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();

        for(LottoTicket lottoTicket : lottoTicketList) {
            List<Integer> ownLottoTicket = lottoTicket.getLottoNumber();
            ownLottoTicket.retainAll(lottoAnswerNumber);
            LottoResult lottoResult = matchNumbers(ownLottoTicket);
            LottoResults.add(lottoResult);
        }
    }

    private LottoResult matchNumbers(List<Integer> ownLottoTicket) {
        LottoResult[] lottoResults = LottoResult.values();
        return Arrays.stream(lottoResults)
                .filter(s -> s.getSameCount() == ownLottoTicket.size())
                .findAny()
                .get();

    }
}
