package lottoauto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int amount) {
        int numberOfLottos = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        while (numberOfLottos-- > 0) {
            lottos.add(Lotto.createAuto());
        }
        return new Lottos(lottos);
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public int totalPrice() {
        return this.lottos.size() * LOTTO_PRICE;
    }

    public RatingStatics findRatingStatics(WinningLotto winningLotto) {
        RatingStatics ratingStatics = RatingStatics.create();
        this.lottos.stream().map(winningLotto::findRating).forEach(ratingStatics::put);
        return ratingStatics;
    }

    @Override
    public String toString() {
        return lottos.stream().map(lotto -> lotto.toString() + "\n").collect(Collectors.joining());
    }
}
