package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LottoMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LottoGuidView view = new LottoGuidView();
        view.getPurchaseAmount(br);

    }
}
