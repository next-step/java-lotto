package my.project.lotto.view;


import my.project.constants.Comments;
import my.project.lotto.domain.GameRecord;
import my.project.lotto.domain.StatRecord;

import java.util.List;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {

    public void printGame(List<GameRecord> records) {
        bought(records);
        grid(records);
    }

    private void bought(List<GameRecord> records) {
        System.out.println(records.size() + Comments.YOU_HAVE_GOT);
    }

    private void grid(List<GameRecord> records) {
        records.forEach(t -> System.out.println(t.toString()));
    }

    public void printStat(StatRecord pf) {
        title();
        div();
        fifth(pf);
        fouth(pf);
        third(pf);
        first(pf);
        profit(pf);
    }

    private void title() {
        System.out.println(Comments.STAT_TITLE);
    }

    private void div() {
        System.out.println(Comments.STAT_DIV);
    }

    private void fifth(StatRecord pf) {
        System.out.println(Comments.STAT_FIFTH + pf.getFifth() + "개");
    }

    private void fouth(StatRecord pf) {
        System.out.println(Comments.STAT_FOURTH + pf.getFourth() + "개");
    }

    private void third(StatRecord pf) {
        System.out.println(Comments.STAT_THIRD + pf.getThird() + "개");
    }

    private void first(StatRecord pf) {
        System.out.println(Comments.STAT_FIRST + pf.getFirst() + "개");
    }

    private void profit(StatRecord pf) {
        System.out.println(pf.toString());
    }

}
