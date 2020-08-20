package domain;

import java.util.List;

public class Games {
    List<Lotto> lottos;

    Games(){

    }

    public static void start(int tries){
        NumberGenerator generator = new NumberGenerator();
        generator.createLottoNumberCandidate();

        for (int i = 0; i < tries; i++) {
            generator.generate();
        }

    }
}
