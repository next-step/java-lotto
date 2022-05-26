package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {

    private static final int MARBLE_CNT = 7;
    private static final int MAX_NUM = 45;
    private static List<Integer> tempInts = new ArrayList<>();

    private List<Marble> marbles;

    static{
        for (int i = 1; i <= MAX_NUM; i++) {
            tempInts.add(i);
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

        List<Integer> randomList = new ArrayList<>();
        Collections.shuffle(tempInts);

        return tempInts.subList(0, MARBLE_CNT)
                .stream()
                .map(n->new Marble(n)).collect(Collectors.toList());
    }

    public int getEachStatistics(int[] winningNums) {
        int match = 0;
        for (int winningNum : winningNums) {
            match = getMatch(match, winningNum);
        }
        return match;
    }

    private int getMatch(int match, int winningNum) {
        if(marbles.contains(new Marble(winningNum))){
            match++;
        }
        return match;
    }

    @Override
    public String toString() {
        return marbles.toString();
    }
}
