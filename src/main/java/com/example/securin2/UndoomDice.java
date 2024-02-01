import java.util.Arrays;

public class UndoomDice {

    public static void main(String[] args) {
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = Arrays.copyOf(dieA, dieA.length);

        int[] newDieA = undoom_dice(dieA, dieB);
        int[] newDieB = Arrays.copyOf(dieB, dieB.length);

        System.out.println("New Die A: " + Arrays.toString(newDieA));
        System.out.println("New Die B: " + Arrays.toString(newDieB));
    }

    public static int[] undoom_dice(int[] dieA, int[] dieB) {
        int[] newDieA = Arrays.copyOf(dieA, dieA.length);

        // Calculate the probabilities for each sum using the original dice
        double[] probabilities = calculateProbabilities(dieA, dieB);

        // Iterate over each face of Die_A
        for (int i = 0; i < newDieA.length; i++) {
            // Iterate over possible values to replace the current face
            for (int newValue = 1; newValue <= 6; newValue++) {
                newDieA[i] = newValue;

                // Calculate new probabilities with the modified Die_A
                double[] newProbabilities = calculateProbabilities(newDieA, dieB);

                // Check if the probabilities match
                if (Arrays.equals(probabilities, newProbabilities)) {
                    break;
                }
            }
        }

        return newDieA;
    }

    // Helper method to calculate probabilities for all possible sums
    private static double[] calculateProbabilities(int[] dieA, int[] dieB) {
        int[] sumsFrequency = new int[11]; // Sums range from 2 to 12

        for (int faceA : dieA) {
            for (int faceB : dieB) {
                int sum = faceA + faceB;
                sumsFrequency[sum - 2]++;
            }
        }

        double[] probabilities = new double[11];
        for (int i = 0; i < probabilities.length; i++) {
            probabilities[i] = (double) sumsFrequency[i] / (dieA.length * dieB.length);
        }

        return probabilities;
    }
}
