import java.util.Arrays;

public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int index = 0;
        for (int j : s) {
            if (index < g.length && g[index] <= j) {
                index++;
                res++;
            }
        }
        return res;
    }
}
