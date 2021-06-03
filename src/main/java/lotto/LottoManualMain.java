package lotto;

import lotto.controller.LottoManualController;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManualMain {
    public static void main(String[] args) {
        List<Lotto> lottos = new ArrayList<>();
        LottoManualController controller = new LottoManualController();
        controller.start(lottos);
    }
}