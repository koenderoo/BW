import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    private static final int R = 256;

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        char[] codelist = new char[R];
        for (int i = 0; i < R; i++) {
            codelist[i] = (char)(i);
        }
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();

        // read characters one at a time
        for (char c: input) {
            char in = c;
            int out;
            for (out = 0; out < R; out++) {
                if (codelist[out] == in) break;
            }

            BinaryStdOut.write((char) out);

            // move character to front
            System.arraycopy(codelist, 0, codelist, 1, out);
            codelist[0] = in;
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode(){
        char[] codelist = new char[R];
        for (int i = 0; i < R; i++) {
            codelist[i] = (char)(i);
        }
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();

        for (char c: input) {
            // read the character one at a time
            int in = c;
            char ch = codelist[in];

            // write the char to binaryout
            BinaryStdOut.write(ch);

            // move character to front
            System.arraycopy(codelist, 0, codelist, 1, in);
            codelist[0] = ch;
        }
        BinaryStdOut.close();
    }

    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) encode();
        else if (args[0].equals("+")) decode();
        else throw new IllegalArgumentException("first argument should be - or +");
    }
}
