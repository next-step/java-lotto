package domain;

import java.util.ArrayList;
import java.util.List;

public class Games {
    private static List<Lotto> lottos= new ArrayList<>();

    Games( ){
    }

    public static List<Lotto> makeLottoTicket(int tries){
        NumberGenerator generator = new NumberGenerator();
        generator.createLottoNumberCandidate();

        for (int i = 0; i < tries; i++) {
            lottos.add(new Lotto(generator.generate()));
        }

        return lottos;
    }
}
