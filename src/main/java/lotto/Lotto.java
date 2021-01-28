package lotto;

import java.util.*;

public class Lotto {
    private static final int VALUE_LEFT_BOUND = 1;
    private static final int VALUE_RIHGT_BOUND = 46;

    private static final int COUNT_LEFT_BOUND = 0;
    private static final int COUNT_RIGHT_BOUND = 5;

    private static final int BONUS_INDEX = 6;

    private LottoTicket lottoNumbers;// TODO:  = new LottoTicket();로또 생성자에서 이부분 추가하기
    private Integer bonusNumber;

    public Lotto() {
        this.lottoNumbers = LottoGenerator.generateLotto();
        // TODO: bonus number;
        this.bonusNumber = 0; // 임의의 값. 나중에 변경
//        for (int i = VALUE_LEFT_BOUND; i <= VALUE_RIHGT_BOUND; i++) {
//            lottoNumbers.add(i);
//        }
//        Collections.shuffle(lottoNumbers);
//        List<Integer> lotto = lottoNumbers.subList(COUNT_LEFT_BOUND, COUNT_RIGHT_BOUND);
//        bonusNumber = lottoNumbers.get(BONUS_INDEX);
    }
    // compare buyers lotto number with answer number
    public int matchLotto(LottoTicket buyerTicket) {
        return this.lottoNumbers.countMatches(buyerTicket);
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLotto() {
        return this.lottoNumbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    public Integer countMatches(List<Integer> usersNumber) {
        Integer count = 0;

        Set<Integer> targetSet = new HashSet<>(lottoNumbers);
        Set<Integer> usersSet = new HashSet<>(usersNumber);

        targetSet.retainAll(usersSet);
        return targetSet.size();
        //TODO : 숫자들을 매칭할 때 set 써야 하는지
        /*for(int i=COUNT_LEFT_BOUND;i<=COUNT_RIGHT_BOUND;i++) {
            count += isEqual(usersNumber.get(i) , lottoNumbers.get(i));
        }
        return count;*/
    }

    private Integer isEqual(Integer users, Integer lotto) {
        if (users == lotto) {
            return 1;
        }
        return 0;
    }
}
