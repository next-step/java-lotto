package lotto.domain;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<LottoNumber> ticket = new HashSet<>();

    public LottoTicket(List<Integer> lottoNumberList) {
        validateTicketNumbers(lottoNumberList);
        for (int i = 0; i < lottoNumberList.size(); i++) {
            LottoNumber lottoNumber = new LottoNumber(lottoNumberList.get(i));
            ticket.add(lottoNumber);
        }
    }

    public boolean isMatchedWithBonusNum(WinnerNumbers winnerNumbers) {
        AtomicBoolean result = new AtomicBoolean(false);
        ticket.iterator().forEachRemaining(number -> {
            if (number.isThisNumberMatched(winnerNumbers.bonusNumber())) {
                result.set(true);
            }
        });
        return result.get();
    }

    public int calculateTotalMatchedCount(WinnerNumbers winnerNumbers) {
        AtomicInteger sum = new AtomicInteger(0);

        ticket.iterator().forEachRemaining(number -> {
            if (number.isThisNumberMatched(winnerNumbers.printWinnerNumbers())) {
                sum.getAndIncrement();
            }
        });

        return sum.get();
    }

    public Boolean isContain(int number) {
        return printLottoNumbers().contains(number);
    }

    public List<Integer> printLottoNumbers() {
        return ticket.stream()
                .map(LottoNumber::lottoNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void validateTicketNumbers(List<Integer> inputInList) {
        if (inputInList.size() != 6) {
            throw new IllegalArgumentException("로또 갯수가 6개가 아닙니다. ");
        }
        Set<Integer> set = new HashSet<>(inputInList);
        if (set.size() != inputInList.size()) {
            throw new IllegalArgumentException("로또 입력시 중복 숫자 불가합니다. ");
        }
    }
}
