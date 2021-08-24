package com.techmoa.lotto.service;

import java.util.Arrays;
import java.util.List;

public class LottoAnswer {

    public static final int DIGIT = 6;

    private static int[] lottoAnswerNumber = new int[DIGIT];

    public LottoAnswer(String enterAnswerString) {
        parseEnterAnswerString(enterAnswerString);
    }

    public void parseEnterAnswerString(String enterAnswerString){
        String[] parseString= enterAnswerString.split(" ");
        this.lottoAnswerNumber=  Arrays.stream(parseString)
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
    }

    public void result(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
    }
}
