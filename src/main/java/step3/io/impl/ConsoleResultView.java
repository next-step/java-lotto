package step3.io.impl;

import java.util.ArrayList;
import java.util.List;

import step3.constant.OutputMessage;
import step3.io.ResultView;

public class ConsoleResultView implements ResultView {

    @Override
    public void showInputPrice() {
        System.out.println(OutputMessage.NEED_PRICE.text());
    }

    @Override
    public void showText(String message) {
        System.out.println(message);
    }

    @Override
    public void buyCount(int size) {
        System.out.println(size + OutputMessage.BUY_TEXT.text());
    }

    @Override
    public void showTotalLotto(List<List<Integer>> lotto) {
        for (List<Integer> one : lotto) {
            showOne(one);
        }
    }

    private void showOne(List<Integer> one) {
        List<String> temp = new ArrayList<>();
        temp.add("[");
        for (Integer number : one) {
            temp.add(String.valueOf(number));
        }
        temp.add("]");
        System.out.println(String.join(" ", temp));
    }
}
