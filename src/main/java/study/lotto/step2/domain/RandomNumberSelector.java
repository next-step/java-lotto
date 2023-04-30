package study.lotto.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberSelector implements AutoNumberSelector {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int FROM_INDEX_FOR_SELECT = 0;
    private static final int TO_INDEX_FOR_SELECT = 6;

    @Override
    public List<Integer> selectedNumber() {
        return selectRandomSixNumber(numbersToSelect());
    }

    private List<Integer> selectRandomSixNumber(List<Integer> numbersToSelect) {
        Collections.shuffle(numbersToSelect);
        List<Integer> selected = numbersToSelect.subList(FROM_INDEX_FOR_SELECT, TO_INDEX_FOR_SELECT);
        Collections.sort(selected);

        return selected;
    }

    private List<Integer> numbersToSelect() {
        return IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
