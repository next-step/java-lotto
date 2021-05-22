package kr.insup.lotto.domain;

import kr.insup.lotto.utils.LottoAutoGenerator;

import java.util.ArrayList;

public class Lottos {

    private ArrayList<Lotto> lottos = new ArrayList<>();

    public Lottos(int attempt) {
        for (int i = 0; i < attempt; i++) {
            lottos.add(new Lotto(new LottoAutoGenerator()));
        }
    }

    public int size() {
        return lottos.size();
    }
}
