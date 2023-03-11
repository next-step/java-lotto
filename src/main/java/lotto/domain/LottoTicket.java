package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Integer> ticket;

    protected LottoTicket(List<Integer> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket create() {
        List<Integer> ticket = createLottoTicket();
        return new LottoTicket(ticket);
    }

    public static LottoTicket of(final List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    private static List<Integer> createLottoTicket() {
        List<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    public int getTicketSize() {
        return ticket.size();
    }

    public LottoRank getHitCount(final List<Integer> numbers, final int bonusNumber) {
        int totalCount = 0;

        for (int number : numbers) {
            totalCount += checkHit(number);
        }

        if (totalCount < 6) {
            boolean isHitBonus = checkBonusNumber(bonusNumber);
            return LottoRank.findRank(totalCount, isHitBonus);
        }

        return LottoRank.findRank(totalCount, false);
    }

    private int checkHit(final int number) {
        return isContain(number) ? 1 : 0;
    }

    public boolean checkBonusNumber(final int number) {
        return isContain(number);
    }

    private boolean isContain(final int number) {
        return this.ticket.contains(number);
    }
}
