package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constraint.Constraint;

public class LottoNumberRandomSelector implements LottoNumberSelectPolicy {


    private final List<Integer> basicNumbers = createBasicNumber();

    @Override
    public List<Integer> selectNumbers() {
        Collections.shuffle(basicNumbers);
        List<Integer> selectedNumbers = basicNumbers.subList(0, Constraint.LOTTO_NUMBER_SIZE);
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }

    private List<Integer> createBasicNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = Constraint.MIN_NUMBER; i <= Constraint.MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

}
