package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Number> lottoNumbers;

    private static final int SIZE = 6;
    private int price;

    public Lotto() {
    }

    private Lotto(List<Number> lottoNumbers, int price) {
        this.lottoNumbers = lottoNumbers;
        this.price = price;
    }

    public static Lotto createLotto(List<Number> list, int price) {
        if (list.size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }

        if(list.size() != distinctNumberCount(list)){
            throw new IllegalArgumentException("로또 중복은 불가능합니다.");
        }
        return new Lotto(list, price);
    }

    private static long distinctNumberCount(List<Number> list) {
        return list.stream()
                .distinct()
                .count();
    }

    public int equalsCount(List<Number> list) {
        return (int) lottoNumbers.stream()
                .filter(list::contains)
                .count();
    }

    public boolean matchBonusNumber(Number bonusNumber){
        return lottoNumbers.stream()
                .anyMatch(t -> t.equals(bonusNumber));
    }

    public void sortLotto() {
        Collections.sort(lottoNumbers);
    }

    public List<Number> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public static int getMaxSize() {
        return SIZE;
    }

    public int getPrice(){
        return price;
    }
}
