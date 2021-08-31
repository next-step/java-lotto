package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constraint.Constraint;

public class LottoNumberRandomSelector implements LottoNumberSelectPolicy {


    private final List<LottoNumber> basicNumbers = createBasicNumber();

    @Override
    public List<LottoNumber> selectNumbers() {
        Collections.shuffle(basicNumbers);
        List<LottoNumber> selectedNumbers = basicNumbers.subList(0, Constraint.LOTTO_NUMBER_SIZE);
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }

    private List<LottoNumber> createBasicNumber() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = Constraint.MIN_NUMBER; i <= Constraint.MAX_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

}
