package edu.nextstep.lottocustom.domain.numbersmaker;

import edu.nextstep.lottocustom.domain.LottoNumber;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AutoNumbersMaker implements NumbersMaker {

    @Override
    public List<LottoNumber> create() {
        return new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .sorted()
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
