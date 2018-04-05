import java.util.Arrays;

public class CircularSuffixArray {

    private String original;
    private int length;
    private String[] sortedSuffixes;
    private int[] sortKey;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s.equals(null)) throw new java.lang.IllegalArgumentException();

        original = s;
        length = original.length();
        String[] suffies = createSuffixes(original);
        sortedSuffixes = suffies;
        sortKey = new int[length];
        for (int i = 0; i < length; i++) sortKey[i] = i;
        sort(sortedSuffixes, sortKey);
        for(int i = 0; i < sortedSuffixes.length; i++)
        { System.out.println(sortedSuffixes[i] + " " + sortKey[i]); }
    }

    private String[] createSuffixes(String s) {
        String[] suffixes = new String[length()];
        for (int i = 0; i < length; i++) {
            suffixes[i] = s.substring(i, length) + s.substring(0, i);
        }
        return suffixes;
    }

    // 3 way string quicksort
    private static void sort(String[] a, int[] b) {
        sort(a, 0, a.length - 1, 0, b);
    }

    private static void sort(String[] a, int lo, int hi, int d, int[] b) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt)
        {
            int t = charAt(a[i], d);
            if      (t < v) exch(a, lt++, i++, b);
            else if (t > v) exch(a, i, gt--, b);
            else            i++;
        }
        sort(a, lo, lt-1, d, b);
        if (v >= 0) sort(a, lt, gt, d+1, b);
        sort(a, gt+1, hi, d, b);
    }

    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }

    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j, int[] b) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        // also exchange the sortKey
        int tempKey = b[i];
        b[i] = b[j];
        b[j] = tempKey;
    }

    // length of s
    public int length() {
        return length;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i > length -1) throw new java.lang.IllegalArgumentException();
        return -1;
    }

    // unit testing (required)
    public static void main(String[] args) {
        String testtext = "dit is een test tekst";
        CircularSuffixArray csa = new CircularSuffixArray(testtext);

    }
}
