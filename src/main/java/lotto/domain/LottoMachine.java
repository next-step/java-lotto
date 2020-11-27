package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.simple();

    public LottoMachine() {}

    public List<Lotto> issue(int purchaseAmount) {
        shouldBuyLotto(purchaseAmount);
        int countOfAutoNumberLotto = countOfAutoNumberLotto(purchaseAmount,0);
        return generateAutoNumberLotto(countOfAutoNumberLotto);
    }

    public List<Lotto> issue(int purchaseAmount, List<String> manualLottoNumbers) {
        shouldBuyLotto(purchaseAmount, manualLottoNumbers.size());
        int countOfAutoNumberLotto = countOfAutoNumberLotto(purchaseAmount, manualLottoNumbers.size());

        List<Lotto> lottos = generateManualNumberLotto(manualLottoNumbers);
        lottos.addAll(generateAutoNumberLotto(countOfAutoNumberLotto, lottos));
        return lottos;
    }

    private void shouldBuyLotto(int purchaseAmount) {
        if( purchaseAmount < Lotto.PRICE ) throw new NotPurchaseLottoException("최소구입금액은 " + Lotto.PRICE + " 웝 입니다");
    }


    private void shouldBuyLotto(int purchaseAmount, int countOfPurchasedManualLotto) {
        int minPrice = Lotto.PRICE;
        if( countOfPurchasedManualLotto > 0 ) minPrice = Lotto.PRICE * countOfPurchasedManualLotto;

        if( purchaseAmount < minPrice ) throw new NotPurchaseLottoException("수동으로 로또 " + countOfPurchasedManualLotto + "장 구입시 소구입금액은 " + minPrice + " 웝 입니다");
    }

    private List<Lotto> generateAutoNumberLotto(int countOfAutoNumberLotto){
        return generateAutoNumberLotto(countOfAutoNumberLotto, new ArrayList<>());
    }
    private List<Lotto> generateAutoNumberLotto(int countOfAutoNumberLotto, List<Lotto> excludeLottos) {
        if( countOfAutoNumberLotto == 0 ) return new ArrayList<>();

        return IntStream.range(0, countOfAutoNumberLotto)
                .mapToObj(it -> generateLotto(excludeLottos))
                .collect(Collectors.toList());
    }

    private List<Lotto> generateManualNumberLotto(List<String> numbers) {
        return numbers.stream().map(Lotto::new).collect(Collectors.toList());
    }

    private int countOfAutoNumberLotto(int purchaseAmount, int countOfManualNumberLotto) {
        return (purchaseAmount / Lotto.PRICE) - countOfManualNumberLotto;
    }

    public PrizeWinningResult checkPrizeWinning(WinningNumbers winningNumbers, List<Lotto> lottos) {
        return checkPrizeWinning(winningNumbers, new Lottos(lottos));
    }

    public PrizeWinningResult checkPrizeWinning(WinningNumbers winningNumbers, Lotto... lottos) {
        return checkPrizeWinning(winningNumbers, new Lottos(lottos));
    }

    private PrizeWinningResult checkPrizeWinning(WinningNumbers winningNumbers, Lottos lottos) {
        return PrizeWinningResult
                .builder()
                .paidMoney(lottos.getPaidMoney())
                .rankedLottos(lottos.checkRanking(winningNumbers))
                .build();
    }

    private Lotto generateLotto(List<Lotto> excludeLottos){
        Lotto generated;
        while(true) {
            generated = new Lotto(lottoNumberGenerator.generate());
            if( !excludeLottos.contains(generated) ) break;
        }
        return generated;
    }


}
