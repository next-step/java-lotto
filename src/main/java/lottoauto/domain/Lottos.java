package lottoauto.domain;

import java.util.*;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> manualLottos) {
        return new Lottos(manualLottos);
    }

    public static Lottos from(int amount) {
        return Lottos.of(amount, null);
    }

    public static Lottos of(int amount, List<Lotto> manualLottos) {
        if (isBlank(manualLottos)) {
            manualLottos = new ArrayList<>();
        }

        List<Lotto> lottos = new ArrayList<>();

        int theNumberOfAutoLottos = theNumberOfPurchasedLottos(amount) - manualLottos.size();

        addManualLottos(manualLottos, lottos);
        addAutoLottos(theNumberOfAutoLottos, lottos);

        return new Lottos(lottos);
    }

    private static boolean isBlank(List<Lotto> manualLottos) {
        return manualLottos == null || manualLottos.isEmpty();
    }

    public static int theNumberOfPurchasedLottos(int amount) {
        return amount / LOTTO_PRICE;
    }

    private static void addAutoLottos(int numberOfAutoLottos, List<Lotto> lottos) {
        while (numberOfAutoLottos-- > 0) {
            lottos.add(Lotto.createAuto());
        }
    }

    private static void addManualLottos(List<Lotto> manualLottos, List<Lotto> lottos) {
        for (Lotto lotto : manualLottos) {
            lottos.add(lotto);
        }
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
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            String s = lotto.toString() + "\n";
            sb.append(s);
        }
        return sb.toString();
    }
}
