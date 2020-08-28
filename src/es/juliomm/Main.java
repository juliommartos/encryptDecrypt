package es.juliomm;

import es.juliomm.app.Application;
import es.juliomm.config.Config;

public class Main {
    public static void main(String[] args) {
        new Application(new Config(args));
    }
}