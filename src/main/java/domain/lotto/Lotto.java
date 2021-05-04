package domain.lotto;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Lotto {
    Random random = new Random();
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;
    List<List<Integer>> allLotto = new ArrayList<>();
    List<Integer> resultCount = new ArrayList<>();
    public Lotto(int payment) {
        int lottoCount = ActionCount(payment);
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = createNonDouplicateNumbers();
            Collections.sort(lottoNumbers);
            allLotto.add(lottoNumbers);
        }
    }
    public int ActionCount(int payment) {
        int lottoCount = payment / LOTTO_PRICE;
        return lottoCount;
    }
    public List<Integer> createNonDouplicateNumbers() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (treeSet.size() != LOTTO_NUMBERS_SIZE) {
            treeSet.add(random.nextInt(45) + 1);
        }
        System.out.println(treeSet);
        List<Integer> lottoNumbers = new ArrayList<>(treeSet);
        return lottoNumbers;
    }

    public void comparisonsToArray(List<Integer> inputNumber) {
        for (List<Integer> arrAll :allLotto) {
            AtomicInteger cnt = new AtomicInteger(0);
            arrAll.forEach( a -> {
                if(inputNumber.contains(a)){
                    cnt.getAndIncrement();
                };
            });
            resultCount.add(cnt.get());
        }
        resultCount.forEach(b -> System.err.println(b));
    }

}
