package step2.domain;

import step2.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private List<Integer> selectedNumbers = new ArrayList<>();

    public Lottery() {
        Util.getShuffled(selectedNumbers);
    }

    public List<Integer> getSelectedNumbers() {
        return this.selectedNumbers;
    }

}
