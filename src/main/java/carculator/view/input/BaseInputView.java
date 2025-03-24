package carculator.view.input;

import carculator.view.ExpressionParser;
import carculator.domain.token.Token;

import java.util.List;

public abstract class BaseInputView implements InputView {

    @Override
    public List<Token> getTokens() {
        System.out.println("계산하고 싶은 문자열을 입력하세요.");
        return ExpressionParser.parseTokens(this.read());
    }

}
