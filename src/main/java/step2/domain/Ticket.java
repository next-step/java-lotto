package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ticket {

    private static final int MARBLE_CNT = 7;
    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;

    private List<Marble> marbles;

    public Ticket(List<Marble> marbles) {
        this.marbles = marbles;
    }

    public Ticket() {
        this(makeMables());
    }

    private static List<Marble> makeMables() {

        List<Marble> marbles = new ArrayList<>();
        for (int i = 0; i < MARBLE_CNT; i++) {
            marbles.add(new Marble(getRandomNum()));
        }
        return marbles;
    }

    private static int getRandomNum() {
        Random rd = new Random();
        return MIN_NUM + rd.nextInt(MAX_NUM);
    }
}
