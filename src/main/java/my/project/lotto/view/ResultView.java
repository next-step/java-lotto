package my.project.lotto.view;


import my.project.constants.Comments;
import my.project.lotto.domain.Lottos;
import my.project.lotto.domain.StatRecord;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {
    public static final String PURCHASED = "개를 구매했습니다.";

    public static void printLottos(Lottos lottos) {
        bought(lottos);
        grid(lottos);
    }

    private static void bought(Lottos lottos) {
        System.out.println(lottos.size() + PURCHASED);
    }

    private static void grid(Lottos lottos) {
        lottos.grid();
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
