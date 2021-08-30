package com.techmoa.lotto.view;

import com.techmoa.lotto.model.LottoWinScope;
import com.techmoa.lotto.service.LottoTicket;
import com.techmoa.lotto.service.LottoTickets;
import com.techmoa.lotto.model.LottoWinResult;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    public void printOwnLotto(LottoTickets lottoTickets){
        List<LottoTicket> lottoTicketsList = lottoTickets.getLottoTickets();

        for(LottoTicket lottoTicket : lottoTicketsList){
            List<Integer> integers = lottoTicket.getLottoNumber();
            StringBuilder stringBuffer = new StringBuilder();
            stringBuffer.append("[");
            for(Integer number : integers) {
                stringBuffer.append(number).append(",");
            }
            stringBuffer.append("]");
            stringBuffer.deleteCharAt(stringBuffer.length()-2);
            System.out.println(stringBuffer);
        }
    }

    public void printAnswerResult(LottoWinResult lottoWinResult) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        LottoWinScope[] lottoWinScope = LottoWinScope.values();
        HashMap<Integer,Integer> winCount = lottoWinResult.getResultMap();
        IntStream.range(0, lottoWinScope.length).forEach(i -> {
            System.out.print(lottoWinScope[i].getSameCountString());
            System.out.println(" " + winCount.get(lottoWinScope[i].getSameCount()));
        });

        System.out.println("총 수익률은 " +lottoWinResult.getProfitRate()+ "입니다.");

    }
}
