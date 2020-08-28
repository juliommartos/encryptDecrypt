package es.juliomm.algorithms;

public class Unicode implements Algorithms {

    /**
     * @param msg text to encode
     * @param key key for text encoding
     * @return encoded text
     */
    public String encode(final String msg, final int key) {
        StringBuilder textPrepared = new StringBuilder();

        for (int i = 0; i < msg.length(); i++)  {
            int keySecret = (int) msg.charAt(i) + key;
            textPrepared.append((char) keySecret);
        }

        return textPrepared.toString();
    }

    /**
     * @param msg - encoded text for decode
     * @param key - The key that was used to encrypt
     * @return text Decoded text
     */
    public String decode(final String msg, final int key) {
        StringBuilder textPrepared = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            int keySecret = msg.charAt(i) - key;
            textPrepared.append((char) keySecret);
        }

        return textPrepared.toString();
    }

}