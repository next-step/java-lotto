package lotto.view.web;

import lotto.view.web.controller.LottoWebMainController;

import static spark.Spark.*;

public class LottoWebMain {
    public static void main(String[] args) {
        port(8080);
        new LottoWebMainController();
    }
}
