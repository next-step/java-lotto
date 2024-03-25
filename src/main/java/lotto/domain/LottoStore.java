package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final Integer PRICE = 1000;

    private final LottoGenerateStrategy lottoPickStrategy;

    public LottoStore(LottoGenerateStrategy lottoPickStrategy) {
        this.lottoPickStrategy = lottoPickStrategy;
    }

    public PickedLottoNumbers buy(Money money) {
        List<LottoNumbers> pickedLottoNumbers = IntStream.generate(() -> 0) // 무한 스트림 생성
                .mapToObj(i -> lottoPickStrategy.generateLottoNumbers()) // generateLottoNumbers() 메소드를 이용해 로또 번호 생성
                .limit(money.getMoney() / PRICE) // money를 PRICE로 나눈 값만큼 번호를 생성하여 제한
                .collect(Collectors.toList()); // 생성된 번호들을 리스트로 변환

        return new PickedLottoNumbers(pickedLottoNumbers);
    }
}