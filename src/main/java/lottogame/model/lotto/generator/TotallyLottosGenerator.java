package lottogame.model.lotto.generator;

import static lottogame.controller.LottoStore.PER_LOTTO_PRICE;

import java.util.List;
import lottogame.model.lotto.Lottos;
import lottogame.model.price.LottoPurchasePrice;

public class TotallyLottosGenerator implements LottosGenerator{
    private final LottoPurchasePrice lottoPurchasePrice;
    private final List<String> manualLottos;

    public TotallyLottosGenerator(LottoPurchasePrice lottoPurchasePrice, List<String> manualLottos) {
        this.lottoPurchasePrice = lottoPurchasePrice;
        this.manualLottos = manualLottos;
    }

    // TODO : 피드백 주신대로 적용해봤습니다.
    //  개인적으로 느낀점은 아래와 같습니다
    //  1. 자동,수동 로또의 생성, 병합을 한 객체 내에서 진행해 로또생성 관련 로직의 응집도가 높아진것 같습니다
    //  2. 추후 Lottos의 생성 관련 작업의 확장성 증가
    //  다만 여기서 고민거리가 또 생겨서 질문드립니다.
    //  고민내용은 두가지 인데요.
    //  1. 저도 명확하게 정의하기 어렵긴한데.. 일종의 컨트롤러 역할을 하는 LottoStore가 직접 Generator를 생성하는게 좋은 방식인지 잘 모르겠습니다.
    //   예를들자면 레이어드 아키택처 구조에서 controller 에서 바로 domain 객체를 생성해 사용하는것 같은.. 그런 느낌을 받아 신경이 쓰이네요
    //  2. 기존 LottoMachine 과 TotallyLottosGenerator 의 차이입니다.
    //   LottoMachine 같은 static 메서드 집합체로 로또생성로직을 활용하는것과 인터페이스-구현체 기반으로 활용하는것의 큰 차이는 무엇이 있는지 잘 생각이 나지 않네요..
    //  좋은 가르침 주시는데 제가 100% 받아들이지 못하는거 같아서 아쉽네요 ㅠㅠ
    @Override
    public Lottos generateLottos() {
        int totalLottoCount = this.lottoPurchasePrice.calculateLottoCount(PER_LOTTO_PRICE);
        int autoLottoCount = totalLottoCount - manualLottos.size();

        Lottos autoLottos = new AutoLottoGenerator(autoLottoCount).generateLottos();
        Lottos manualLottos = new ManualLottosGenerator(this.manualLottos).generateLottos();

        return autoLottos.merge(manualLottos);
    }
}
