package lotto;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private final List<Lotto> myLottos = new ArrayList<>(); // 사용자 지갑 내 모든 로또 리스트 변수

    /**
     * 생성자
     */
    public Wallet() {

    }

    /**
     * 사용자의 로또 리스트 반환 함수
     *
     * @return
     */
    public List<Lotto> getLottos() {
        return myLottos;
    }

    /**
     * 사용자의 로또 리스트 대입 함수
     *
     * @param lottos 로또 리스트 변수
     */
    public void addLottos(List<Lotto> lottos) {
        myLottos.addAll(lottos);
    }


}
