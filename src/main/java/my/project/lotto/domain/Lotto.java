package my.project.lotto.domain;

import my.project.constants.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-23 오전 11:24
 * Developer : Seo
 */
public class Lotto {
    private List<GameRecord> records;

    public Lotto() {
        this.records = new ArrayList<>();
    }

    public List<GameRecord> games(GameInfo info) {
        for (int i = 0; i < info.getCount(); i++) {
            game();
        }
        return records;
    }

    private void game() {
        Machine machine = new Machine();
        GameRecord record = new GameRecord();
        for (int i = 0; i < Rule.ONE_GAME_COUNT; i++) {
            record.add(machine.pop());
        }
        records.add(record);
    }

}
