import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        int len = str.length();
        int max = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            int j = i;
            while (j < len && str.charAt(j) == ch) {
                j++;
            }

            max = Math.max(max, j - i);

            i = j - 1;
        }
        return max; // YOUR CODE HERE
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();

        boolean isNumber = false;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (i + 1 < len) {
                    int count = str.charAt(i) - '0';
                    while (count > 0) {
                        sb.append(str.charAt(i + 1));
                        count--;
                    }
                } else if (!isNumber && i > 0) {
                    sb.append(str.charAt(i));
                }
                isNumber = true;

            } else {
                isNumber = false;
                sb.append(str.charAt(i));
            }

        }
        return sb.toString(); // YOUR CODE HERE
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }

        for(int i = 0; i < b.length() - len; i++) {
            if(set.contains(b.substring(i, i + len))) {
                return true;
            }
        }
        return false; // YOUR CODE HERE
    }
}