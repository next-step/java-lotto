package step2_2;

import static step2_2.InputView.readLottoNumbers;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        List<LottoNumber> list = readLottoNumbers();
        list.forEach(System.out::println);
    }
}
