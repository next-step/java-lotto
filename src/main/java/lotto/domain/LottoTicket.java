package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private List<Integer> ticket;

    protected LottoTicket(List<Integer> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket create() {
        List<Integer> ticket = createLottoTicket();
        return new LottoTicket(ticket);
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

    public LottoRank getHitCount(List<Integer> numbers, int bonusNumber) {
        int totalCount = 0;

        for (int number : numbers) {
            totalCount += checkHit(number);
        }

        boolean hasBonus = hasBonusNumber(bonusNumber);
        return LottoRank.findRank(totalCount, hasBonus);
    }

    private int checkHit(int number) {
        return isContain(number) ? 1 : 0;
    }

    public boolean hasBonusNumber(int number) {
        return isContain(number);
    }

    private boolean isContain(int number) {
        return this.ticket.contains(number);
    }
}
