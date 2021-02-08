package lotto.view;

import lotto.wrapper.Count;
import lotto.wrapper.Money;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int amount = 0;

    public static Money inputAmount() {
        try {
            amount = Integer.parseInt(input.readLine());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        if (amount < 1000) {
            throw new IllegalArgumentException("복권은 1000원 부터 구매 가능합니다.");
        }
        return new Money(amount);
    }

    public Count inputAmountManual() {
        try {
            amount = Integer.parseInt(input.readLine());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return new Count(amount);
    }

    public List<String> selectLottosManually(Count lottosManual) {
        List<String> lottosManualRaw = new ArrayList<>();
        for(int i=0; i<lottosManual.getCount(); i++){
            lottosManualRaw.add(inputOneLotto());
        }
        return lottosManualRaw;
    }

    private String inputOneLotto() {
        String lottoManualRaw = null;
        try{
            lottoManualRaw = input.readLine();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return lottoManualRaw;
    }

}
