import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Integer[]> list = new ArrayList<>();

        //checks whether arguments has been passed
        if (args.length > 0) {
            try {
                BufferedReader br = Files.newBufferedReader(Paths.get(args[0]));
                //reads first line containing number of lines to read
                int n = Integer.parseInt(br.readLine());

                //reads line and adds int array to list
                for (int i = 0; i < n; i++) {
                    String[] line = br.readLine().split(DELIMITER);
                    list.add(new Integer[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
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

    private static void printGraphCount(List<Integer[]> list) {
        int count = 0;

        //set with visited vertices
        Set<Integer> checked = new HashSet<>();

        for (Integer[] pair : list) {
            for (Integer current : pair) {
                if (checked.add(current)) {
                    traverseGraph(checked, list, current);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void traverseGraph(Set<Integer> checked, List<Integer[]> list, Integer current) {
        Set<Integer> adjacentVertices = list
                .stream()
                .filter(x -> x[0].equals(current) || x[1].equals(current)) // filter list for pairs that contains current value
                .flatMap(Stream::of) // flatmap stream from Integer[] to Integer
                .filter(x -> !checked.contains(x)) // exclude values already checked
                .collect(Collectors.toSet());

        checked.addAll(adjacentVertices);

        for (Integer adjacent : adjacentVertices) {
            traverseGraph(checked, list, adjacent); // recursive call for other values
        }
    }
}

