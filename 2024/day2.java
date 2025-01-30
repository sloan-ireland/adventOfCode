import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class day2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("2024/day2_input.txt");

        // Part 1
        Scanner scanner = new Scanner(file);
        int countPart1 = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] levels = line.split(" ");
            int[] levelInts = new int[levels.length];

            for (int i = 0; i < levels.length; i++) {
                levelInts[i] = Integer.parseInt(levels[i]);
            }

            if (isSafeReport(levelInts)) {
                countPart1++;
            }
        }

        scanner.close();
        System.out.println("Part 1: " + countPart1);

        // Part 2
        scanner = new Scanner(file); // Reset scanner to the beginning of the file
        int countPart2 = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] levels = line.split(" ");
            int[] levelInts = new int[levels.length];

            for (int i = 0; i < levels.length; i++) {
                levelInts[i] = Integer.parseInt(levels[i]);
            }

            // Check if the original report is safe
            boolean isSafe = isSafeReport(levelInts);

            if (!isSafe) {
                // Try removing each level and check if it becomes safe
                for (int i = 0; i < levelInts.length; i++) {
                    int[] modifiedLevels = new int[levelInts.length - 1];
                    int index = 0;

                    for (int j = 0; j < levelInts.length; j++) {
                        if (j != i) {
                            modifiedLevels[index++] = levelInts[j];
                        }
                    }

                    if (isSafeReport(modifiedLevels)) {
                        isSafe = true;
                        break;
                    }
                }
            }

            if (isSafe) {
                countPart2++;
            }
        }

        scanner.close();
        System.out.println("Part 2: " + countPart2);
    }

    // Helper method to determine if a report is safe
    private static boolean isSafeReport(int[] levels) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < levels.length; i++) {
            int diff = levels[i] - levels[i - 1];
            if (diff < 1 || diff > 3) {
                increasing = false;
            }
            if (diff > -1 || diff < -3) {
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }
}
