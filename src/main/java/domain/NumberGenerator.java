package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {

    List<Integer> numList;
    List<Integer> lottoNumberCandidate;

    public NumberGenerator(){
        numList = new ArrayList<>();
        lottoNumberCandidate= new ArrayList<>();
    }

    public void createLottoNumberCandidate(){
        lottoNumberCandidate = IntStream.rangeClosed(1,45)
                .boxed().collect(Collectors.toList());
    }

    public List<Integer> generate() {

        Collections.shuffle(lottoNumberCandidate);
        numList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            numList.add(lottoNumberCandidate.get(i));
//            System.out.println(lottoNumberCandidate.get(i));
        }

        return numList;
    }

}
