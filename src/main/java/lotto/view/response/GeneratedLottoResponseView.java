package lotto.view.response;


import java.util.List;

public class GeneratedLottoResponseView {

    public static void show(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }
}
