package step2;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {

    private final List<Lotto> lottos;

    public PlayLotto(int rounds) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public int getLottoSize(){
        return lottos.size();
    }

}
