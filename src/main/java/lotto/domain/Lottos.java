package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private static Random random = new Random();

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = makeLotto();
            lottos.add(lotto);
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(Lottos manualLottos, Lottos autoLottos) {
        this.lottos = mergeLottos(manualLottos, autoLottos);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public Lotto getLottoIndex(int index) {
        return lottos.get(index);
    }

    private Lotto makeLotto() {
        Set<LottoNumber> lottoNumbers = new TreeSet<>(Comparator.comparing(LottoNumber::getNumber));
        while (lottoNumbers.size() != 6) {
            LottoNumber number = new LottoNumber(random.nextInt(45) + 1);
            lottoNumbers.add(number);
        }
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> mergeLottos(Lottos manualLottos, Lottos autoLottos){

        List<Lotto> mergeList = new ArrayList<>();

        mergeManualLottos(manualLottos, mergeList);
        mergeAutoLottos(autoLottos, mergeList);

        return mergeList;
    }

    private void mergeAutoLottos(Lottos autoLottos, List<Lotto> mergeList) {
        for(int i = 0; i< autoLottos.getLottosSize(); i++){
            mergeList.add(autoLottos.getLottoIndex(i));
        }
    }

    private void mergeManualLottos(Lottos manualLottos, List<Lotto> mergeList) {
        for(int i = 0; i< manualLottos.getLottosSize(); i++){
            mergeList.add(manualLottos.getLottoIndex(i));
        }
    }
}
