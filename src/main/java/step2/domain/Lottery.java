package step2.domain;

import step2.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private List<Integer> selectedNumbers = new ArrayList<>();
    private int matched;

    public Lottery() {
        Util.getShuffled(selectedNumbers);
        Util.getSorted(selectedNumbers);
        this.matched = 0;
    }

    public Lottery(List<Integer> winningNumber) {
        Util.getSorted(winningNumber);
        this.selectedNumbers = winningNumber;
    }

    public List<Integer> getSelectedNumbers() {
        return this.selectedNumbers;
    }

}
