package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.ui.LottoHitInfo;
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

    public LottoRank getHitCount(final LottoHitInfo hitInfo) {
        List<Integer> hitNumbers = hitInfo.getHitNumbers();
        int bonusNumber = hitInfo.getBonusNumber();

        int totalCount = 0;

        for (int number : hitNumbers) {
            totalCount += checkHit(number);
        }

        if (totalCount < 6) {
            boolean isHitBonus = hasBonusNumber(bonusNumber);
            return LottoRank.findRank(totalCount, isHitBonus);
        }

        return LottoRank.findRank(totalCount, false);
    }


    private int checkHit(final int number) {
        return isContain(number) ? 1 : 0;
    }

    public boolean hasBonusNumber(final int number) {
        return isContain(number);
    }

    private boolean isContain(final int number) {
        return this.ticket.contains(number);
    }

    public void printLottoNumbers() {
        System.out.println(this.ticket);
    }
}
