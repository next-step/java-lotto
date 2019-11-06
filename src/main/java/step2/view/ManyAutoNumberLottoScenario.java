package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import step2.io.Input;
import step2.io.Output;
import step2.lotto.Lottos;
import step2.shop.LottoShop;
import step2.statistics.DefaultLottoStatistics;

import static step2.lotto.LottoConstant.DEFAULT_LOTTO_PRICE;

public class ManyAutoNumberLottoScenario {
    private final Input input;
    private final Output output;
    private final LottoShop lottoShop;

    public ManyAutoNumberLottoScenario(final Input input, final Output output, final LottoShop lottoShop) {
        this.input = input;
        this.output = output;
        this.lottoShop = lottoShop;
    }

    public void execute() {
        output.write("구입금액을 입력해 주세요.");
        final int price = Integer.parseInt(input.nextLine());
        final int amount = price / DEFAULT_LOTTO_PRICE;

        final Lottos lottos = lottoShop.buyAuto(amount);
        output.write(String.format("%s개를 구매했습니다.", amount));
        output.write(lottos.toString());

        output.write("지난 주 당첨 번호를 입력해 주세요");
        final List<Integer> winNumbers = Arrays.stream(input.nextLine().split(","))
                                               .map(Integer::parseUnsignedInt)
                                               .collect(Collectors.toList());

        final DefaultLottoStatistics lottoStatistics = lottos.stats(winNumbers);
        output.write("당첨 통계");
        output.write("---------");

        Stream.of(3, 4, 5, 6)
              .map(i -> String.format("%s개 일치 (%s원)- %s개", i, lottoStatistics.priceSum(i), lottoStatistics.match(i)))
              .forEach(output::write);

        output.write(String.format("총 수익률은 %s%%입니다.", lottoStatistics.priceSum() / price));
    }
}
