package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int UNIT_PRICE = 1000;

    public static List<Lotto> generate(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public static int amonut(int price) {
        if (price % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("로또의 1장당 가격은 1,000원입니다. 원하는 장수 만큼의 금액을 입력해주세요.");
        }
        return price / UNIT_PRICE;
    }
}
