package nextstep.lotto.view;

import nextstep.lotto.dto.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static nextstep.lotto.constant.PrintMessage.RESULT_TEXT_BUY_TOTAL_AMOUNT;

public class ResultView {

    private final String LOTTO_RESULT_STAT = "당첨통계";
    private final String LOTTO_RESULT_LINE_SEPERATOR = "--------";
    private final String LOTTO_TICKET_PREFIX = "[";
    private final String LOTTO_TICKET_SUFFIX = "]";
    private final String LOTTO_TICKET_DELIMITER = ",";

    private final String BENEFIT_RATE_TEXT = "총 수익률은 %.2f 입니다.";

    private final String MATCH_INFO_TEXT_MATCH_COUNT = "개 일치(";
    private final String MATCH_INFO_TEXT_REWARD = "원)-";
    private final String MATCH_INFO_TEXT_TICKET_COUNT = "개";

    private final String MATCH_INFO_LINE_SPERATOR = "\n";

    private final int DEFAULT_TICKET_COUNT = 0;

    public void showLottoTicket(LottoTickets tickets) {
        printTicketCount(tickets.count());

        for(LottoTicket ticket : tickets.getAll()) {
            printTicket(ticket);
        }
    }
    private void printTicketCount(int ticketCount) {
        System.out.println(ticketCount+RESULT_TEXT_BUY_TOTAL_AMOUNT);
    }

    private void printTicket(LottoTicket ticket) {
        System.out.println(lottoNumberToString(ticket.getLottoNumber()));
    }

    private String lottoNumberToString(List<LottoNumber> lottoNumbers){
        StringJoiner lottoTicketNumbers = new StringJoiner(LOTTO_TICKET_DELIMITER,LOTTO_TICKET_PREFIX,LOTTO_TICKET_SUFFIX);
        for(LottoNumber lottoNumber : lottoNumbers) {
            lottoTicketNumbers.add(String.valueOf(lottoNumber.getNumber()));
        }
        return lottoTicketNumbers.toString();
    }

    public void showLottoResultBoard(LottoResultBoard resultBoard) {
        System.out.println(LOTTO_RESULT_STAT);
        System.out.println(LOTTO_RESULT_LINE_SEPERATOR);

        Map<LottoRank,Integer> lottoResult = resultBoard.getLottoResult();
        StringBuilder sb = new StringBuilder();
        sb.append(getMatchInfo(LottoRank.THREE, lottoResult.getOrDefault(LottoRank.THREE,DEFAULT_TICKET_COUNT)));
        sb.append(getMatchInfo(LottoRank.FOUR, lottoResult.getOrDefault(LottoRank.FOUR,DEFAULT_TICKET_COUNT)));
        sb.append(getMatchInfo(LottoRank.FIVE, lottoResult.getOrDefault(LottoRank.FIVE,DEFAULT_TICKET_COUNT)));
        sb.append(getMatchInfo(LottoRank.SIX, lottoResult.getOrDefault(LottoRank.SIX,DEFAULT_TICKET_COUNT)));
        System.out.println(sb.toString());

        System.out.printf(BENEFIT_RATE_TEXT,resultBoard.getBenefitRate());
    }

    private String getMatchInfo(LottoRank rank, int matchCount){
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchCount())
                .append(MATCH_INFO_TEXT_MATCH_COUNT)
                .append(rank.getReward())
                .append(MATCH_INFO_TEXT_REWARD)
                .append(matchCount)
                .append(MATCH_INFO_TEXT_TICKET_COUNT)
                .append(MATCH_INFO_LINE_SPERATOR);

        return sb.toString();
    }
}
