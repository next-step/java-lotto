package domain.lotto;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;
    Random random = new Random();
    AllLotto allLotto = new AllLotto();
    private double payment;
    private double lottoCount;

    public Lotto() {

    }

    public Lotto(double payment) {
        double lottoCount = ActionCount(payment);
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = createNonDouplicateNumbers();
            Collections.sort(lottoNumbers);
            allLotto.add(lottoNumbers);
        }
    }

    public double ActionCount(double payment) {
        this.payment = payment;
        lottoCount = payment / LOTTO_PRICE;
        return lottoCount;
    }

    public List<Integer> createNonDouplicateNumbers() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (treeSet.size() != LOTTO_NUMBERS_SIZE) {
            treeSet.add(random.nextInt(45) + 1);
        }
        List<Integer> lottoNumbers = new ArrayList<>(treeSet);
        return lottoNumbers;
    }


}
