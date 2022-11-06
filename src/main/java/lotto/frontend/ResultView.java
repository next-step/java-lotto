package lotto.frontend;

import lotto.backend.domain.LottoNumber;
import lotto.backend.domain.LottoRank;
import lotto.backend.domain.LottoTicket;
import lotto.backend.dto.LottoResultDto;
import lotto.backend.dto.LottoTicketsDto;

import java.text.MessageFormat;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER = ", ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String LOTTO_COUNT_MESSAGE_PATTERN = "수동으로 {0}장, 자동으로 {1}개를 구매했습니다.";
    private static final String MATCH_MESSAGE_PATTERN = "{0}개 일치 ({1}원)- {2}개";
    private static final String MATCH_BONUS_MESSAGE_PATTERN = "{0}개 일치, 보너스 볼 일치 ({1}원)- {2}개";
    private static final String PROFIT_MESSAGE_PATTERN = "총 수익률은 {0,number,0.00}입니다. {1}";
    private static final String PROFIT_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void printLottoNumber(LottoTicketsDto lottoTickets) {
        System.out.println(assembleBuyingResult(lottoTickets));
    }

    private String assembleBuyingResult(LottoTicketsDto lottoTicketsDto) {
        return STRING_BUILDER.append(LINE_SEPARATOR)
                .append(assembleLottoCount(lottoTicketsDto))
                .append(LINE_SEPARATOR)
                .append(assembleLottoTickets(lottoTicketsDto))
                .append(LINE_SEPARATOR)
                .toString();
    }

    private String assembleLottoCount(LottoTicketsDto lottoTicketsDto) {
        return MessageFormat.format(LOTTO_COUNT_MESSAGE_PATTERN, lottoTicketsDto.countOfAuto(), lottoTicketsDto.countOfCustom());
    }

    private String assembleLottoTickets(LottoTicketsDto lottoTicketsDto) {
        return IntStream.range(0, lottoTicketsDto.countOfTicket())
                .mapToObj(i -> assembleLottoTicket(lottoTicketsDto.getValues().get(i)))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private String assembleLottoTicket(LottoTicket lottoTicket) {
        return lottoTicket.getValue().stream()
                .sorted()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    public void printLottoResult(LottoResultDto lottoResultDto) {
        STRING_BUILDER.setLength(0);
        System.out.println(assembleLottoResult(lottoResultDto));
    }

    private String assembleLottoResult(LottoResultDto lottoResultDto) {
        return STRING_BUILDER
                .append(LINE_SEPARATOR)
                .append("당첨 통계")
                .append(LINE_SEPARATOR)
                .append("------------------")
                .append(LINE_SEPARATOR)
                .append(assembleLottoMatchResult2(lottoResultDto.getRanking()))
                .append(LINE_SEPARATOR)
                .append(assembleProfit(lottoResultDto.getProfit()))
                .toString();
    }

    private String assembleLottoMatchResult2(Map<LottoRank, Integer> ranking) {
        return ranking.entrySet().stream()
                .map(i -> assembleMatchResult(i.getKey().getCountOfMatch(), i.getKey().hasBonusNumber(), i.getKey().getMoneyPrize(), i.getValue()))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private String assembleMatchResult(int rank, boolean hasBonus, int prize, int match) {
        if (hasBonus) {
            return MessageFormat.format(MATCH_BONUS_MESSAGE_PATTERN, rank, prize, match);
        }
        return MessageFormat.format(MATCH_MESSAGE_PATTERN, rank, prize, match);
    }

    private String assembleProfit(double profit) {
        return MessageFormat.format(PROFIT_MESSAGE_PATTERN, profit, lessThenZero(profit) ? PROFIT_LOSS_MESSAGE : "");
    }

    private boolean lessThenZero(double profit) {
        return profit < 1;
    }
}
