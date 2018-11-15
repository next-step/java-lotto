package lotto.domain;

import lotto.view.InputView;

import java.util.List;

public class LottoGenerator {

    public static void generateLotto(Lotto lotto, List<String> lottoNumbers) {
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        List<Ticket> autoTickets = autoLottoGenerator.generate();

        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(lottoNumbers);
        List<Ticket> manualTickets = manualLottoGenerator.generate();

        lotto.addTickets(autoTickets);
        lotto.addTickets(manualTickets);
    }
}
