package lotto.model;

import java.util.Collections;
import lotto.model.generator.LottoGenerator;
import lotto.model.generator.LottoNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoRequest {

    public static final int LOTTO_PRICE = 1000;

    private final Money money;
    private final List<String> manualLottoStrs;

    public LottoRequest(int money, List<String> manualLottoStrs) {
        this.money = new Money(money);

        if (lottoBuyChance() - manualLottoStrs.size() < 0) {
            throw new IllegalArgumentException("구매 비용이 모자랍니다.");
        }

        this.manualLottoStrs = manualLottoStrs;
    }

    private int lottoBuyChance() {
        return money.buyChance(LOTTO_PRICE);
    }

    public LottoWallet buy() {
        LottoGenerator lottoGenerator = new LottoGenerator(new LottoNumberGenerator());
        List<RequestDto> requests = manualLottoStrs
                .stream()
                .map(str -> List.of(str.split(",")))
                .map(LottoRequest::parse)
                .map(RequestDto::new)
                .collect(Collectors.toList());

        int size = lottoBuyChance();
        int autoSize = size - manualLottoStrs.size();

        requests.addAll(Collections.nCopies(autoSize, new RequestDto()));

        List<Lotto> lottos = requests
                .stream()
                .map(lottoGenerator::generate)
                .collect(Collectors.toList());

        return new LottoWallet(lottos, manualLottoStrs.size());
    }

    private static List<Integer> parse(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}


