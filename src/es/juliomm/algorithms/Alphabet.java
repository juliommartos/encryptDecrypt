package es.juliomm.algorithms;

public class Alphabet implements Algorithms {

    public String encode(final String msg, final int key) {
        StringBuilder textPrepared = new StringBuilder();

        for (int i = 0; i < msg.length(); i++)  {
            int keySecret = msg.charAt(i);

            if (keySecret >= 65 && keySecret <= 90) {
                if ((keySecret + key) > 90) {
                    keySecret = (keySecret + key) - 90;
                    keySecret = 64 + keySecret;
                    textPrepared.append((char) keySecret);

                } else {
                    textPrepared.append((char) (keySecret + key));
                }

            } else if (keySecret >= 97 && keySecret <= 122) {
                if ((keySecret + key) > 122) {
                    keySecret = (keySecret + key) - 122;
                    keySecret = 96 + keySecret;
                    textPrepared.append((char) keySecret);

                } else {
                    textPrepared.append((char)( keySecret + key));
                }

            } else {
                textPrepared.append((char) keySecret);
            }

        }

        return textPrepared.toString();
    }

    public String decode(String msg, int key) {
        StringBuilder textPrepared = new StringBuilder();

        for (int i = 0; i < msg.length(); i++)  {
            int keySecret = msg.charAt(i);

            if (keySecret >= 65 && keySecret <= 90) {
                if ((keySecret - key) < 65) {
                    keySecret = 65 - (keySecret - key);
                    keySecret = 91 - keySecret;
                    textPrepared.append((char) keySecret);

                } else {
                    textPrepared.append((char) (keySecret - key));
                }

            } else if (keySecret >= 97 && keySecret <= 122) {
                if ((keySecret - key) < 97) {
                    keySecret = 97 - (keySecret - key);
                    keySecret = 123 - keySecret;
                    textPrepared.append((char) keySecret);

                } else {
                    textPrepared.append((char)( keySecret - key));
                }

            } else {
                textPrepared.append((char) keySecret);
            }

        }

        return textPrepared.toString();
    }
}
