package lottos.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRandomGenerator implements LottoGenerator {

    @Override
    public List<Integer> generate() {
        Set<Integer> randoms = new HashSet<>();
        while (randoms.size() != 6) {
            int number = (int) (Math.random() * 45) + 1;
            randoms.add(number);
        }
        return new ArrayList<>(randoms);
    }
}
