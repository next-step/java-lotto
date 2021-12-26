package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int LIMIT = 6;
    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;

    static final List<Integer> lottoDefaultNumbers = IntStream.range(FIRST_NUMBER, LAST_NUMBER).boxed().collect(Collectors.toList());

    public Lotto lotto(int count) {
        if(count <= 0) {
            throw new IllegalArgumentException();
        }
        List<NumberGroup> numberGroups = new ArrayList<>();

        while(count-- > 0) {
            Collections.shuffle(lottoDefaultNumbers);
            numberGroups.add(numberGroup());
        }

        return new Lotto(numberGroups);
    }

    public NumberGroup numberGroup() {
        return new NumberGroup(lottoDefaultNumbers.stream()
                .limit(LIMIT).map(n -> new Number(n)).collect(Collectors.toList()));
    }
}
