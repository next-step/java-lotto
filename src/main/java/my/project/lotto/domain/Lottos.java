package my.project.lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-23 오전 11:24
 * Developer : Seo
 */
public class Lottos {
    public static final int NUMBERS = 6;
    public static final int FIRST_PRICE = 2_000_000_000;
    public static final int THIRD_PRICE = 1_500_000;
    public static final int FOURTH_PRICE = 50_000;
    public static final int FIFTH_PRICE = 5_000;

    private List<GameRecord> records;

    public Lottos() {
        this.records = new ArrayList<>();
    }

    public static List<GameRecord> lotto(Ticket ticket) {
        isTicketQualified(ticket);

        List<GameRecord> records = new ArrayList<>();
        for (int i = 0; i < ticket.getTickets(); i++) {
        }
        return records;
    }

    private static void isTicketQualified(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("티켓을 확인해주십시요.");
        }
    }

    private void game() {
        Machine machine = new Machine();
        GameRecord record = new GameRecord();
        for (int i = 0; i < NUMBERS; i++) {
            record.add(machine.pop());
        }
        records.add(record);
    }

}
