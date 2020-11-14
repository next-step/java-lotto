package lotto.service;

import lotto.domain.Pick;
import lotto.domain.enums.PickType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutoPickService {

    List<Integer> balls = Stream.iterate(1, ballNumber -> ballNumber + 1)
            .limit(45)
            .collect(Collectors.toList());

    public Pick pick() {
        Collections.shuffle(balls);
        return new Pick(PickType.AUTO, balls.subList(0,5));
    }
}
