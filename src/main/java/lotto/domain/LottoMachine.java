package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;
    public static final int LOTTO_NUMBER_GROUP_LIMIT = 6;

    static final List<Integer> lottoDefaultNumbers = IntStream.range(FIRST_NUMBER, LAST_NUMBER).boxed().collect(Collectors.toList());

    public LottoMachine() {
        Collections.shuffle(lottoDefaultNumbers);
    }

    public Lotto lotto(int count) {
        if(count <= 0) {
            throw new IllegalArgumentException();
        }
        List<NumberGroup> numberGroups = new ArrayList<>();

        while(count-- > 0) {
            numberGroups.add(numberGroup());
        }

        return new Lotto(numberGroups);
    }

    public NumberGroup numberGroup() {
        int[] index = {0};
        return new NumberGroup(lottoDefaultNumbers.stream()
                .limit(LOTTO_NUMBER_GROUP_LIMIT).map(n -> new Number(n, new Position(index[0]++))).collect(Collectors.toList()));
    }
}
