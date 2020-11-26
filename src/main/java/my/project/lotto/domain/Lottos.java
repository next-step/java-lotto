package my.project.lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-23 오전 11:24
 * Developer : Seo
 */
public class Lottos {
    public static final int FIRST_PRICE = 2_000_000_000;
    public static final int THIRD_PRICE = 1_500_000;
    public static final int FOURTH_PRICE = 50_000;
    public static final int FIFTH_PRICE = 5_000;

    private Lottos() {
    }

    public static List<Lotto> lotto(Chance chance) {
        if (chance == null) {
            throw new IllegalArgumentException("참여할 기회가 없습니다.");
        }

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < chance.getChances(); i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }
}
