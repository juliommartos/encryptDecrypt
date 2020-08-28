package es.juliomm.app;

import es.juliomm.config.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    private final Config conf;
    private final SelectAlgorithm algorithm;
    private String textToProcess;

    public Application(Config conf) {
        this.conf = conf;
        algorithm = new SelectAlgorithm();
        algorithm.select(conf);

        getTextToProcess();

        String textProcessed = algorithm.execute(conf, textToProcess);

        showResult(textProcessed);
    }

    private void getTextToProcess() {
        if (conf.getData().isEmpty() && !conf.getIn().isEmpty()) {
            try {
                File file = new File(conf.getIn());
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {
                    textToProcess = scanner.nextLine();
                }

                scanner.close();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            textToProcess = conf.getData();
        }
    }

    private void showResult(String text) {
        if (!conf.getOut().isEmpty()) {
            File file = new File(conf.getOut());

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(text);

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println(text);
        }
    }
}
