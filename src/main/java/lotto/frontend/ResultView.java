package lotto.frontend;

import lotto.backend.domain.LottoNumber;
import lotto.backend.domain.LottoTicket;
import lotto.backend.dto.LottoResultDto;
import lotto.backend.dto.LottoTicketsDto;

import java.text.MessageFormat;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final int MIN_MATCH = 3;
    private static final int MAX_MATCH = 6;
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER = ", ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String MATCH_MESSAGE_PATTERN = "{0}개 일치 ({2}원)- {1}개";
    private static final String PROFIT_MESSAGE_PATTERN = "총 수익률은 {0,number,0.00}입니다. {1}";
    private static final String PROFIT_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void printLottoNumber(LottoTicketsDto lottoTickets) {
        System.out.println(assembleBuyingResult(lottoTickets));
    }

    private String assembleBuyingResult(LottoTicketsDto lottoTicketsDto) {
        return STRING_BUILDER.append(lottoTicketsDto.countOfTicket())
                .append("개를 구매하였습니다.")
                .append(LINE_SEPARATOR)
                .append(assembleLottoTickets(lottoTicketsDto))
                .append(LINE_SEPARATOR)
                .toString();
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
                .append(assembleLottoMatchResult(lottoResultDto))
                .append(LINE_SEPARATOR)
                .append(assembleProfit(lottoResultDto))
                .toString();
    }

    private String assembleLottoMatchResult(LottoResultDto lottoResultDto) {
        return IntStream.range(MIN_MATCH, MAX_MATCH + 1)
                .mapToObj(i -> assembleMatchResult(i, lottoResultDto.findMatch(i), lottoResultDto.findPrize(i)))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private String assembleMatchResult(int rank, int match, int prize) {
        return MessageFormat.format(MATCH_MESSAGE_PATTERN, rank, match, prize);
    }

    private String assembleProfit(LottoResultDto lottoResultDto) {
        double profit = lottoResultDto.findProfit();
        return MessageFormat.format(PROFIT_MESSAGE_PATTERN,
                profit, lessThenZero(profit) ? PROFIT_LOSS_MESSAGE : "");
    }

    private boolean lessThenZero(double profit) {
        return profit < 1;
    }
}
