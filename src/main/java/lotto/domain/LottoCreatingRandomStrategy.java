package lotto.domain;

import java.util.Random;

public class LottoCreatingRandomStrategy implements LottoCreatingStrategy {

    @Override
    public Lotto create() {
        Random random = new Random();
        return null;
    }
}
