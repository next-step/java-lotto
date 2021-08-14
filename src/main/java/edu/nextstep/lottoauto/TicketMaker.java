package edu.nextstep.lottoauto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketMaker {

    private static final List<Integer> TOTAL_NUMBERS = new ArrayList<>();
    private static final int PRICE_PER_ONE_TICKET = 1000;

    private int makingCount;

    private TicketMaker(){
    }

    static{
        setTotalNumbers();
    }

    public static TicketMaker create() {
        return new TicketMaker();
    }

    public List<List<Integer>> makeTickets(int payment) {
        if (payment < 1000) {
            throw new IllegalArgumentException("최소 1,000원 이상 입력 가능합니다.(1장에 1,000원)");
        }

        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1,000 원 단위로 입력 가능합니다.");
        }

        this.makingCount = payment / PRICE_PER_ONE_TICKET;

        List<List<Integer>> lottoTickets = new ArrayList<>();

        while (makingCount > 0) {
            Collections.shuffle(TOTAL_NUMBERS);
            lottoTickets.add(TOTAL_NUMBERS.subList(0, 6));
            makingCount--;
        }

        return lottoTickets;
    }

    private static void setTotalNumbers() {
        for (int i = 1; i <= 45; i++) {
            TOTAL_NUMBERS.add(i);
        }
    }

    protected static int getPricePerOneTicket() {
        return PRICE_PER_ONE_TICKET;
    }

    protected static List<Integer> getTotalNumbers() {
        return TOTAL_NUMBERS;
    }


}
