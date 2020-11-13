package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<List<Integer>> lottoNumbers){
        lottoNumbers.forEach( lottoNumber -> lottos.add(new Lotto(lottoNumber)));
    }

    public int size(){
        return lottos.size();
    }

    public Stream stream(){
        return lottos.stream();
    }
}
