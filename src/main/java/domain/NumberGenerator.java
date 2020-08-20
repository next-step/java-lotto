package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    private final int startNumber = 1;
    private final int finalNumber = 45;
    List<Integer> numList;
    List<Integer> lottoNumberCandidate;

    public NumberGenerator(){
        numList = new ArrayList<>();
        lottoNumberCandidate= new ArrayList<>();

    }

    public void createLottoNumberCandidate(){
        for (int i = startNumber; i <= finalNumber; i++) {
            lottoNumberCandidate.add(i);
        }
    }

    public List<Integer> generate() {

        Collections.shuffle(lottoNumberCandidate);

        for (int i = 0; i < 6; i++) {
            numList.add(lottoNumberCandidate.get(i));
        }

        return numList;
    }

    private void shuffleAndMakeLotto(){

    }
}
