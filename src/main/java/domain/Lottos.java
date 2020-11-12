package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int numberOfLottos){
        for(int i = 0; i < numberOfLottos; i++){
            lottos.add(new Lotto(Collections.EMPTY_LIST));
        }
    }

    public int size(){
        return lottos.size();
    }
}
