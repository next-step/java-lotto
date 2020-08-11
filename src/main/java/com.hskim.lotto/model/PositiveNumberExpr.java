package com.hskim.lotto.model;

import java.util.Collections;
import java.util.List;

public class PositiveNumberExpr {

    public List<String> tokenList;

    public PositiveNumberExpr(String input) {

        tokenList = Collections.emptyList();
    }

    public List<String> getTokenList() {

        return tokenList;
    }
}
