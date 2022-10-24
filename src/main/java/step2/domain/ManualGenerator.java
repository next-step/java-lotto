package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualGenerator implements LottoPagersGenerator {
    private final LottoPapers lottoPapers;

    public ManualGenerator(List<List<Integer>> manualLottoPapersInput) {
        lottoPapers = create(manualLottoPapersInput);
    }

    @Override
    public LottoPapers getLottoPapers() {
        return lottoPapers;
    }

    private LottoPapers create(List<List<Integer>> manualLottoPapersInput) {
        List<LottoPaper> lottoPapers = manualLottoPapersInput.stream()
                .map(LottoPaper::new)
                .collect(Collectors.toList());
        return new LottoPapers(lottoPapers);
    }
}
