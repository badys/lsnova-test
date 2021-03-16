import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Piotr Badysiak
 */
public class task {

    private static final String DELIMITER = " ";

    /**
     * Prints how many separated graphs are in the input.
     *
     * @param args 0 - filename
     */
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();

        //checks whether arguments has been passed
        if (args.length > 0) {
            try {
                BufferedReader br = Files.newBufferedReader(Paths.get(args[0]));
                //reads first line containing number of lines to read
                int n = Integer.parseInt(br.readLine());

                //reads line and adds int array to list
                for (int i = 0; i < n; i++) {
                    String[] line = br.readLine().split(DELIMITER);
                    list.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            System.out.println("No file was provided!");
            return;
        }

        printGraphCount(list);
    }

    private static void printGraphCount(List<int[]> list) {
        int count = 0;

        //set with values
        Set<Integer> uniqueVertices = new HashSet<>();

        for (int[] pair : list) {
            // if both values are unique that means it is separate graph
            boolean added = uniqueVertices.add(pair[0]);
            added &= uniqueVertices.add(pair[1]);
            if (added)
                count++;
        }

        System.out.println(count);
    }
}

