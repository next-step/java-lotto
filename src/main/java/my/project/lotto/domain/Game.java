package my.project.lotto.domain;

import my.project.constants.Rule;

/**
 * Created : 2020-11-23 오전 11:24
 * Developer : Seo
 */
public class Game {
    private final Machine machine;
    private final Record record;

    public Game() {
        this.machine = new Machine();
        this.record = new Record();
    }

    public void game() {
        for (int i = 0; i < Rule.ONE_GAME_COUNT; i++) {
            record.add(machine.pop());
        }
    }

    public Record record() {
        return this.record;
    }
}
