package calculator.domain;

import calculator.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public int compute(String formula){

        //숫자만 담기
        List<Integer> nums = new ArrayList<>();

        //사칙연산만 담기
        List<String>  opers = new ArrayList<>();

        //숫자, 사칙연산 사이에 공백있는지 등등 확인
        StringUtils.valid(formula);

        //분류하기
        String[] parts = formula.split(" ");
        for (String part : parts) {
            if(StringUtils.isNumber(part)){
                nums.add(Integer.parseInt(part));
            }else{
                opers.add(part);
            }
        }

        int res = nums.get(0);

        for(int i = 1; i < nums.size(); i++){
            String op = opers.get(i - 1);

            res = operate(op, res, nums.get(i));
        }

        return res;
    }

    private int operate(String op, int res, Integer nextNum) {
        if(op.equals("+")){
            return new AddOperation().compute(res, nextNum);
        }

        if(op.equals("-")){
            return new SubstractOperation().compute(res, nextNum);
        }

        if(op.equals("*")){
            return new MultiplyOperation().compute(res, nextNum);
        }

        if(op.equals("/")){
            return new DivideOperation().compute(res, nextNum);
        }

        return 0;
    }
}
