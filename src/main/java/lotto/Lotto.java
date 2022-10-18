package lotto;

import java.util.*;

public class Lotto {

    public static final int MAX_SIZE = 6;
    public static final int LOTTO_BOUND_NUM = 46;

    private List<Integer> lottoNums = new ArrayList<>();

    public Lotto() {
        Random random = new Random();
        Set<Integer> tmpLottoNums = new HashSet<>();
        while (tmpLottoNums.size() < MAX_SIZE) {
            int lottoNum = random.nextInt(LOTTO_BOUND_NUM);
            tmpLottoNums.add(lottoNum);
        }
        lottoNums = new ArrayList<>(tmpLottoNums);
        Collections.sort(lottoNums);
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return "" + lottoNums;
    }

    public static void main(String[] args) {
        System.out.println(new Lotto());
    }
}
