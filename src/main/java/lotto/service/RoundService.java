package lotto.service;

import lotto.domain.Pick;
import lotto.domain.Round;

import java.util.Set;

public class RoundService {
    public Round buy(Set<Pick> myPicks) {
        Round round = new Round();
        round.setMyPicks(myPicks);
        return round;
    }
}
