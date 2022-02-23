package lotto.domain;

import lotto.domain.lottogenerator.ManualLottoGenerator;
import lotto.domain.lottogenerator.RandomLottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    public static Lottos purchase(Ticket ticket, List<String[]> manualLottos) {
        List<Lotto> userLottos = Stream.concat(
                        generateManualLotto(manualLottos).stream(),
                        generateAutoLotto(ticket.getAutoCount()).stream()
                    )
                    .collect(Collectors.toList());

        return new Lottos(userLottos);
    }

    private static List<Lotto> generateManualLotto(List<String[]> manualLottos) {
        return manualLottos.stream()
                .map(ManualLottoGenerator::new)
                .map(ManualLottoGenerator::get)
                .collect(Collectors.toList());
    }

    private static List<Lotto> generateAutoLotto(int count) {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        List<Lotto> autoLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            autoLottos.add(lottoGenerator.get());
        }
        return autoLottos;
    }
}
