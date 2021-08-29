package lotto.domain;

import lotto.util.LottoNumbersFactory;
import lotto.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoTickets {
    private final List<LottoNumbers> lottoTickets;

    private final TicketCount autoTicketCount;

    public static LottoTickets init(final String[] inputManualLottoTickets, final TicketCount autoTicketCount) {
        List<LottoNumbers> lottoTickets = toLottoTickets(inputManualLottoTickets);
        lottoTickets.addAll(makeAutoLottoTickets(autoTicketCount));
        return new LottoTickets(lottoTickets, autoTicketCount);
    }

    private static List<LottoNumbers> toLottoTickets(final String[] inputManualLottoTickets) {
        return Arrays.stream(inputManualLottoTickets)
                .map(manualLottoNumbers -> new LottoNumbers(StringUtil.split(manualLottoNumbers)))
                .collect(toList());
    }

    private static List<LottoNumbers> makeAutoLottoTickets(final TicketCount ticketCount) {
        return IntStream.range(0, ticketCount.getValue())
                .mapToObj(index -> LottoNumbersFactory.makeAutoLottoNumbers())
                .collect(toList());
    }

    private LottoTickets(final List<LottoNumbers> lottoTickets, final TicketCount autoTicketCount) {
        checkNullOrEmpty(lottoTickets);
        this.lottoTickets = lottoTickets;
        this.autoTicketCount = autoTicketCount;
    }

    private void checkNullOrEmpty(final List<LottoNumbers> lottoTickets) {
        if (Objects.isNull(lottoTickets) || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("lottoTickets는 null이거나 empty 일 수 없습니다.");
        }
    }

    public Result check(final WinningNumbers winningNumbers) {
        Result result = new Result();
        lottoTickets.stream()
                .map(winningNumbers::checkWinning)
                .forEach(result::report);
        return result;
    }

    public List<LottoNumbers> getLottoTickets() {
        return lottoTickets;
    }

    public int getAutoTicketCount() {
        return autoTicketCount.getValue();
    }

    public int getManualTicketCount() {
        return lottoTickets.size() - getAutoTicketCount();
    }
}
