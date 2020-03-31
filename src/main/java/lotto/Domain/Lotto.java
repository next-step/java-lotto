package lotto.Domain;


import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lottoNumber;

    private Lotto(List<Integer> lottoNumber) {
        lottoNumberCountException(lottoNumber.size());
        Collections.shuffle(lottoNumber);
        Collections.sort(lottoNumber);
        this.lottoNumber = lottoNumber.subList(0, 6);
    }

    public static Lotto init(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private void lottoNumberCountException(int lottoNumberCount) {
        if(lottoNumberCount < 6) {
            throw new IllegalArgumentException(lottoNumberCount + "개의 로또 번호가 입력되었습니다.");
        }
    }

    public int match(List<Integer> winningNumber) {
        int matchCount = 0;
        for (Integer number : winningNumber) {
            matchCount += (lottoNumber.contains(number)) ? 1 : 0;
        }
        return matchCount;
    }

    public List<Integer> toList() {
        return Collections.unmodifiableList(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }
}
