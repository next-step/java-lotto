package carculator.view.input;

import carculator.domain.token.Token;

import java.util.List;

public interface InputView {

    String read();

    List<Token> getTokens();
}
