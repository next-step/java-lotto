package lotto.application;

import lotto.controller.Controller;
import lotto.service.Service;

import static spark.Spark.port;

public class WebApplication {
    public static void main(String[] args) {
        port(8080);

        new Controller(Service.getInstance());
    }
}
