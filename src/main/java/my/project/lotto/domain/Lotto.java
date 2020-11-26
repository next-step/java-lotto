package my.project.lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-23 오전 11:24
 * Developer : Seo
 */
public class Lotto {
    public static final int NUMBERS = 6;
    public static final int FIRST_PRICE = 2_000_000_000;
    public static final int THIRD_PRICE = 1_500_000;
    public static final int FOURTH_PRICE = 50_000;
    public static final int FIFTH_PRICE = 5_000;

    private List<GameRecord> records;

    public Lotto() {
        this.records = new ArrayList<>();
    }

    public List<GameRecord> games(Ticket info) {
        for (int i = 0; i < info.getCount(); i++) {
            game();
        }
        return records;
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
