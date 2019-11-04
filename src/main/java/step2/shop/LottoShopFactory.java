package step2.shop;

import java.util.Arrays;
import java.util.List;

public final class LottoShopFactory {
    public static LottoShop alwaysSame(final Integer... numbers) {
        return alwaysSame(Arrays.asList(numbers));
    }

    public static LottoShop alwaysSame(final List<Integer> numbers) {
        return new LottoShop(new AlwaysSameLottoNumberGenerationPolicy(numbers));
    }

    public static LottoShop random() {
        return new LottoShop(new RandomLottoNumberGenerationPolicy());
    }
}
