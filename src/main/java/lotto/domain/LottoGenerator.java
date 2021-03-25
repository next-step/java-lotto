package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    public final static int ZERO_SIZE = 0;
    private final static LottoNumbers LOTTO_NUMBERS = new LottoNumbers();

    private LottoGenerator() { }

    public static List<Lotto> autoGenerate(int quantity) {
        return Stream.generate(LOTTO_NUMBERS::lottoNumbers)
                .limit(quantity)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public static List<Lotto> manualGenerate(String[] values) {
        return Arrays.stream(values)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public static List<Lotto> generate(PrePurchaseInformation prePurchaseInformation) {
        List<Lotto> lottos = autoGenerate(prePurchaseInformation.autoQuantity());
        if (prePurchaseInformation.manualQuantity() > ZERO_SIZE) {
            lottos.addAll(manualGenerate(prePurchaseInformation.values()));
        }
        return lottos;
    }
}
