package my.project.lotto.view;


import my.project.constants.Comments;
import my.project.lotto.domain.GameRecord;

import java.util.List;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {

    public void print(List<GameRecord> records) {
        bought(records);
        grid(records);
    }

    private void bought(List<GameRecord> records) {
        System.out.println(records.size() + Comments.YOU_HAVE_GOT);
    }

    private void grid(List<GameRecord> records) {
        records.forEach(t -> System.out.println(t.toString()));
    }

}
