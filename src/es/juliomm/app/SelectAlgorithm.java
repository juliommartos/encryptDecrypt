package es.juliomm.app;

import es.juliomm.config.Config;
import es.juliomm.algorithms.*;

public class SelectAlgorithm {
    private Algorithms algorithm;

    protected void select(Config conf) {
        switch (conf.getAlg()) {
            case "shift" -> algorithm = new Alphabet();
            case "unicode" -> algorithm = new Unicode();
        }
    }

    protected String execute(Config conf, String text) {
        return switch (conf.getMode()) {
            case "enc" -> algorithm.encode(text, conf.getKey());
            case "dec" -> algorithm.decode(text, conf.getKey());
            default -> null;
        };
    }
}
