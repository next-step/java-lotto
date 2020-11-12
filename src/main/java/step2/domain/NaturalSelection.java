package step2.domain;

import java.util.*;

public class NaturalSelection {

    public Set<Integer> select(List<Integer> numberPool, int count) {
        Set<Integer> numberPoolSet = new HashSet<>(numberPool);
        if (numberPoolSet.size() != numberPool.size()) {
            throw new DuplicateNumberPoolException();
        }
        if (numberPoolSet.size() < count) {
            throw new NotEnoughNumberPoolSizeException();
        }
        if (count < 1) {
            throw new IllegalCountException();
        }

        List<Integer> modifiableNumberPool = new ArrayList<>(numberPool);
        Collections.shuffle(modifiableNumberPool);
        return new HashSet<>(modifiableNumberPool.subList(0, count));
    }

}
