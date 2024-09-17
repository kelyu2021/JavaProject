import java.util.HashSet;
import java.util.Set;

public class test {


    public static int highestReachableIndex(int steps, int badIndex) {
        // Assume a sufficiently large array size to accommodate all reachable indices
        // This array size should be greater than or equal to the maximum reachable index.
        // For simplicity, we use a large enough size; adjust if needed.
        int maxPossibleIndex = (steps * (steps + 1)) / 2;
        boolean[] reachable = new boolean[maxPossibleIndex + 1];
        reachable[0] = true;

        for (int j = 1; j <= steps; j++) {
            for (int i = maxPossibleIndex; i >= 0; i--) {
                if (reachable[i] && i + j <= maxPossibleIndex && i + j != badIndex) {
                    reachable[i + j] = true;
                }
            }
        }

        // Find the highest reachable index
        for (int i = maxPossibleIndex; i >= 0; i--) {
            if (reachable[i]) {
                return i;
            }
        }

        return -1; // In case no index is reachable, though this should not happen
    }

    public static void main(String[] args) {
        int steps = 4;
        int forbiddenIndex = 6;
        System.out.println("Highest reachable index: " + highestReachableIndex(steps, forbiddenIndex)); // Output should be 6
    }


}
