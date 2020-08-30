package nextstep.lotto.view;

import nextstep.lotto.dto.*;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;


public class ResultView {

    private final String LOTTO_RESULT_STAT = "당첨통계";
    private final String LOTTO_RESULT_LINE_SEPERATOR = "--------";
    private final String LOTTO_TICKET_PREFIX = "[";
    private final String LOTTO_TICKET_SUFFIX = "]";
    private final String LOTTO_TICKET_DELIMITER = ",";

    private final String RESULT_TEXT_BUY_DETAIL = "수동으로 %s장, 자동으로 %s개 를 구매했습니다.\n";
    private final String BENEFIT_RATE_TEXT = "총 수익률은 %.2f 입니다.";

    private final String MATCH_INFO_TEXT_MATCH_COUNT = "개 일치(";
    private final String MATCH_INFO_TEXT_MATCH_COUNT_BONUS = "개 일치, 보너스 볼 일치(";
    private final String MATCH_INFO_TEXT_REWARD = "원)-";
    private final String MATCH_INFO_TEXT_TICKET_COUNT = "개";

    private final String MATCH_INFO_LINE_SPERATOR = "\n";

    private final long DEFAULT_TICKET_COUNT = 0;

    public void showLottoTicket(LottoTickets tickets, LottoBuyManger lottoBuyManger) {
        printTicketCount(lottoBuyManger);

        for (LottoTicket ticket : tickets.getAll()) {
            printTicket(ticket);
        }
    }

    private void printTicketCount(LottoBuyManger lottoBuyManger) {
        System.out.printf(RESULT_TEXT_BUY_DETAIL, lottoBuyManger.getManualLottoAmount(), lottoBuyManger.getAutoAmount());
    }

    private void printTicket(LottoTicket ticket) {
        System.out.println(lottoNumberToString(ticket.getLottoNumber()));
    }

    private String lottoNumberToString(List<LottoNumber> lottoNumbers) {
        StringJoiner lottoTicketNumbers = new StringJoiner(LOTTO_TICKET_DELIMITER, LOTTO_TICKET_PREFIX, LOTTO_TICKET_SUFFIX);
        for (LottoNumber lottoNumber : lottoNumbers) {
            lottoTicketNumbers.add(String.valueOf(lottoNumber.getNumber()));
        }
        return lottoTicketNumbers.toString();
    }

    public void showLottoResultBoard(LottoResultBoard resultBoard) {
        System.out.println(LOTTO_RESULT_STAT);
        System.out.println(LOTTO_RESULT_LINE_SEPERATOR);

        Map<LottoRank, Long> lottoResult = resultBoard.getLottoResult();
        StringBuilder sb = new StringBuilder();
        sb.append(getMatchInfo(LottoRank.FIFTH, lottoResult.getOrDefault(LottoRank.FIFTH, DEFAULT_TICKET_COUNT)));
        sb.append(getMatchInfo(LottoRank.FOURTH, lottoResult.getOrDefault(LottoRank.FOURTH, DEFAULT_TICKET_COUNT)));
        sb.append(getMatchInfo(LottoRank.THIRD, lottoResult.getOrDefault(LottoRank.THIRD, DEFAULT_TICKET_COUNT)));
        sb.append(getMatchInfo(LottoRank.SECOND, lottoResult.getOrDefault(LottoRank.SECOND, DEFAULT_TICKET_COUNT)));
        sb.append(getMatchInfo(LottoRank.FIRST, lottoResult.getOrDefault(LottoRank.FIRST, DEFAULT_TICKET_COUNT)));
        System.out.println(sb.toString());

        System.out.printf(BENEFIT_RATE_TEXT, resultBoard.getBenefitRate());
    }

    private String getMatchInfo(LottoRank rank, long matchCount) {
        String matchInfoText = MATCH_INFO_TEXT_MATCH_COUNT;
        if (rank == LottoRank.SECOND) {
            matchInfoText = MATCH_INFO_TEXT_MATCH_COUNT_BONUS;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchCount())
                .append(matchInfoText)
                .append(rank.getReward())
                .append(MATCH_INFO_TEXT_REWARD)
                .append(matchCount)
                .append(MATCH_INFO_TEXT_TICKET_COUNT)
                .append(MATCH_INFO_LINE_SPERATOR);

        return sb.toString();
    }
}
