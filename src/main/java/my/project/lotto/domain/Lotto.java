package my.project.lotto.domain;

/**
 * Created : 2020-11-23 오전 11:01
 * Developer : Seo
 */
public class Lotto {
    private final Games games;

    public Lotto(int inputMoney) {
        this.games = new Games(inputMoney);
    }

}
