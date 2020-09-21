package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoIssuer {

    private LottoIssuer(){}

    public static List<Lotto> issueAutoLottos(int issueCount) {
        if (issueCount < 0) {
            throw new IllegalArgumentException("구매 수량은 적어도 1 이상 이어야 합니다.");
        }

        return IntStream.range(0, issueCount)
                .mapToObj(idx -> Lotto.create(LottoNumber.getRandomLottoNumber()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public static List<Lotto> issueNonAutoLotto(List<String> customLottoNumberList) {
        return IntStream.range(0, customLottoNumberList.size())
                .mapToObj(idx -> Lotto.create(customLottoNumberList.get(idx)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}




