package com.ssabae.nextstep.lotto.domain.lotto;

import static com.ssabae.nextstep.lotto.Constant.LOTTO_TICKET_PRICE;

import com.ssabae.nextstep.lotto.application.LottoResultDto;
import com.ssabae.nextstep.lotto.application.LottoResultDto.LottoResultDtoBuilder;
import com.ssabae.nextstep.lotto.domain.LottoResult;
import com.ssabae.nextstep.lotto.domain.LottoTicketsAnalyzer;
import com.ssabae.nextstep.lotto.domain.Money;
import com.ssabae.nextstep.lotto.domain.WinningNumber;
import com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator.LottoTicketGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class LottoTicketMachine {

    private final LottoTicketGenerator autoGenerator;

    private final LottoTicketsAnalyzer analyzer;

    public LottoTicketMachine(LottoTicketGenerator autoGenerator) {
        this.autoGenerator = autoGenerator;
        this.analyzer = new LottoTicketsAnalyzer();
    }

    public LottoTickets buy(Money amount, List<String> manualTicketStrings) {
        validate(amount, manualTicketStrings);
        List<LottoTicket> lottoTicketList = generateTickets(amount, manualTicketStrings);
        return LottoTickets.of(lottoTicketList, manualTicketStrings.size());
    }

    public List<LottoTicket> generateTickets(Money amount, List<String> manualTicketStrings) {
        int count = calculateTicketCount(amount);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.addAll(generateManualTicket(manualTicketStrings));
        lottoTicketList.addAll(generateAutoTicket(count - manualTicketStrings.size()));
        return lottoTicketList;
    }

    public LottoResultDto calculateYield(LottoTickets lottoTickets, WinningNumber winningNumber) {
        LottoResult result = this.analyzer.analyze(lottoTickets, winningNumber);
        return LottoResultDtoBuilder.builder()
                .matchCountMap(result.getMatchCountMap())
                .earnRate(result.calculateEarnRate())
                .build();
    }

    private void validate(Money amount, List<String> manualTicketStrings) {
        if (amount.isLessThen(LOTTO_TICKET_PRICE)) {
            throw new IllegalArgumentException(LOTTO_TICKET_PRICE + "원 이상이여야 합니다.");
        }

        Money manualTicketAmount = LOTTO_TICKET_PRICE.times(manualTicketStrings.size());
        if (amount.isLessThen(manualTicketAmount)) {
            throw new IllegalArgumentException("수동으로 구매할 비용은 총 금액보다 적어야합니다.");
        }
    }

    private int calculateTicketCount(Money amount) {
        return (int) (amount.getAmountLongValue() / LOTTO_TICKET_PRICE.getAmountLongValue());
    }

    private List<LottoTicket> generateManualTicket(List<String> manualTicketStrings) {
        return manualTicketStrings.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> generateAutoTicket(int count) {
        return Stream.generate(autoGenerator::generate)
                .limit(count)
                .collect(Collectors.toList());
    }
}
