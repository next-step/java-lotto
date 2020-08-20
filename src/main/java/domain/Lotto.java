package domain;

import java.util.List;

public class Lotto {
    List<Integer> sixNumber;

    public Lotto(List<Integer> list){
        this.sixNumber = list;
    }

    public List<Integer> getSixNumber() {
        return sixNumber;
    }
}
