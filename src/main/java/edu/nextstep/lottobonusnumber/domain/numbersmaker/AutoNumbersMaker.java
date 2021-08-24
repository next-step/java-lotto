package edu.nextstep.lottobonusnumber.domain.numbersmaker;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AutoNumbersMaker implements NumbersMaker{

    @Override
    public List<Integer> create() {
        return new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());
    }
}
