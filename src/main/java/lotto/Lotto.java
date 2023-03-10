package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lotto.LottoOrganizer.LottoGrade;

public class Lotto {

    private final List<Integer> lotto = new ArrayList<>(); // 구매한 로또의 번호들을 저장할 리스트 변수

    public static LottoGrade grade = null; // 구매한 로또의 당첨 등수

    /**
     * 생성자
     *
     * @param lottery
     */
    public Lotto(List<Integer> lottery) {
        this.lotto.addAll(lottery);
    }

    /**
     * 로또 반환 함수
     *
     * @return
     */
    public List<Integer> getLotto() {
        return lotto;
    }

    /**
     * 로또 당첨 순위 반환 함수
     *
     * @return
     */
    public LottoGrade getThisLottoGrade() {
        return grade;
    }

    // toString() 추가
}
