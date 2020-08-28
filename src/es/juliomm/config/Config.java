package es.juliomm.config;

public class Config {

    private String mode;
    private String data;
    private String out;
    private String in;
    private String alg;
    private int key;

    public Config(String[] args) {
        this.mode = "enc";
        this.data = "";
        this.out = "";
        this.in = "";
        this.alg = "shift";
        this.key = 0;

        readArgs(args);
    }

    private void readArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode" -> mode = args[i + 1];
                case "-key" -> key = Integer.parseInt(args[i + 1]);
                case "-data" -> data = args[i + 1];
                case "-out" -> out = args[i + 1];
                case "-in" -> in = args[i + 1];
                case "-alg" -> alg = args[i + 1];
            }
        }
    }

    public String getAlg() {
        return alg;
    }

    public String getMode() {
        return mode;
    }

    public String getData() {
        return data;
    }

    public String getOut() {
        return out;
    }

    public String getIn() {
        return in;
    }

    public int getKey() {
        return key;
    }
}
