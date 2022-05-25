package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ticket {

    private static final int MARBLE_CNT = 7;
    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;
    private static List<Integer> generator = new ArrayList<>();

    private List<Marble> marbles;

    static{
        for (int i = 1; i <= MAX_NUM; i++) {
            generator.add(i);
        }
    }

    public Ticket(List<Marble> marbles) {
        this.marbles = marbles;
    }

    public Ticket() {
        this(makeMables());
    }

    private static List<Marble> makeMables() {

        List<Marble> marbles = new ArrayList<>();

        List<Integer> randomList = new ArrayList<>(generator);
        Collections.shuffle(randomList);

        randomList = randomList.subList(0, MARBLE_CNT);
        for (Integer random : randomList) {
            marbles.add(new Marble(random));
        }

        return marbles;
    }
}
