package lotto.step1;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    // 생성자
    public Wallet() {}

    // 사용자 지갑 내 모든 로또 리스트 변수
    private final List<Lotto> lottoList = new ArrayList<>();

    //사용자의 로또 리스트 반환 함수
    public List<Lotto> getLottos() {
        return lottoList;
    }

    //사용자의 로또 리스트 대입 함수
    public void addLottos(List<Lotto> lottos) {
        lottoList.addAll(lottos);
    }
}
