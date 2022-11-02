package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lotto {

    public static final int TICKET_AMOUNT = 1000;

    public static final int NO_AUTO_TICKET_AMOUNT = 0;

    private final List<Ticket> ticketList;

    public Lotto(int amount) {
        this(amount, null, false);
    }

    public Lotto(List<Ticket> ticketList) {
       this(NO_AUTO_TICKET_AMOUNT, ticketList, false);
    }

    public Lotto(int amount, List<Ticket> ticketList) {
        this(amount, ticketList, true);
    }
    public Lotto(int amount, List<Ticket> ticketList, boolean matchAmountAndTicketList) {
        List<Ticket> totalTicketList = new ArrayList<>();
        ticketList = Optional.ofNullable(ticketList)
                .orElseGet(() -> new ArrayList<>());

        totalTicketList.addAll(ticketList);
        int autoTicketCount = convertAmountToAutoTicketCount(amount, totalTicketList.size(), matchAmountAndTicketList);

        List<Ticket> autoTicketList = makeTicketList(autoTicketCount);
        totalTicketList.addAll(autoTicketList);
        this.ticketList = totalTicketList;
    }

    public static int convertAmountToAutoTicketCount(int amount, int prepareTicketListSize, boolean matchAmountAndTicketList) {
        int autoTicketCount = convertAmountToTicketCount(amount);
        if (matchAmountAndTicketList) {
            autoTicketCount = autoTicketCount - prepareTicketListSize;
        }
        if (autoTicketCount < 0) {
            throw new IllegalArgumentException(String.format("구입금액보다 많은 로또를 생성할수 없습니다."));
        }

        return autoTicketCount;
    }

    public static int convertAmountToTicketCount(int amount) {
        return amount / TICKET_AMOUNT;
    }

    public static List<Ticket> makeTicketList(int count) {
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ticket ticket = Ticket.create();
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public int getTicketCount() {
        return ticketList.size();
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public Ranks rankedWinningNumbers(WinningTicket winningTicket) {
        List<Rank> ranks = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            ranks.add(matchRank(winningTicket, ticket));
        }
        return new Ranks(ranks, getPurchageAmount());
    }

    public static Rank matchRank(WinningTicket winningTicket, Ticket ticket) {
        int matchCount = getWinningNumbersMatchCount(winningTicket.getTicket(), ticket);
        boolean matchBonus = ticket.getLottoNumbers().contains(winningTicket.getBonusNumber());
        return Rank.of(matchCount, matchBonus);
    }

    public static int getWinningNumbersMatchCount(Ticket winningTicket, Ticket ticket) {
        int matchCount = 0;
        for (LottoNumber tiketNumber : ticket.getLottoNumbers()) {
            matchCount = increaseMatchCount(winningTicket, tiketNumber, matchCount);
        }
        return matchCount;
    }


    public static int increaseMatchCount(Ticket winningTicket, LottoNumber tiketNumber, int matchCount) {
        if (winningTicket.getLottoNumbers().contains(tiketNumber)) {
            matchCount++;
        }
        return matchCount;
    }

    public int getPurchageAmount(){
        return ticketList.size() * Lotto.TICKET_AMOUNT;
    }




}
