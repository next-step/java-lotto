package study.ascii92der.lotto.step3;

import com.sun.glass.ui.Clipboard;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(String[] lottoArray) {
        lottoList = new ArrayList<>();
        for (String lottoNumbers : lottoArray) {
            this.lottoList.add(new Lotto(lottoNumbers));
        }
    }


    public int size() {
        return this.lottoList.size();
    }
}
