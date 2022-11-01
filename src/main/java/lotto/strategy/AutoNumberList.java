package lotto.strategy;

import lotto.domain.LottoBall;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoNumberList implements NumberList {

    private static final int START_UNIT = 0;
    private static final int END_UNIT = 6;

    @Override
    public List<LottoNumber> makeNumberList() {
        return sortNumber(getNumberList());
    }

    private static List<LottoNumber> sortNumber(List<Integer> numberList) {
        List<LottoNumber> sortedNumber = numberList.stream()
                .sorted(Integer::compareTo)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return Collections.unmodifiableList(sortedNumber);
    }

    private static List<Integer> getNumberList() {
        List<Integer> pickNumber = new ArrayList<>();

        for (int i = LottoBall.getStartNumber(); i < LottoBall.getLastNumber(); i++) {
            pickNumber.add(i);
        }
        Collections.shuffle(pickNumber);

        return pickNumber.subList(START_UNIT, END_UNIT);
    }

}
