import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Piotr Badysiak
 */
public class task {

    //variables
    private static final long RANDOM_STREAM_SIZE = 10;
    private static final int RANDOM_MIN_BOUND = 0;
    private static final int RANDOM_MAX_BOUND = 13;

    private static final String DELIMITER = " ";


    /**
     * Prints pairs that meets the target
     * If no target is provided, default 13 is used.
     * @param args 0 - filename, 1 - target
     */
    public static void main(String[] args) {
        int target = 13;
        List<Integer> list;

        //checks whether arguments has been passed
        if (args.length > 0) {
            try {
                list = Files.readAllLines(Paths.get(args[0])) // read all lines from file
                        .parallelStream()
                        .flatMap(line -> Arrays.stream(line.split(DELIMITER)).map(x -> Integer.valueOf(x.trim()))) // flat map list of lines into stream of single integers
                        .collect(Collectors.toList()); // collect to list

                if (args.length > 1)
                    target = Integer.parseInt(args[1]);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        } else {
            //no args passed - use random list
            list = (new Random())
                    .ints(RANDOM_STREAM_SIZE, RANDOM_MIN_BOUND, RANDOM_MAX_BOUND)
                    .boxed()
                    .collect(Collectors.toList());
        }

        printPairs(list, target);
    }

    private static void printPairs(List<Integer> list, int target) {
        //convert list to array for easier index access
        Integer[] array = list.toArray(new Integer[0]);

        //create result list - dynamic arraylist size
        List<Integer[]> results = new ArrayList<>();

        //iterate over all numbers
        for (int i = 0; i < array.length; i++) {
            Integer first_number = array[i];
            //iterate only over right side of the list
            for (int j = i + 1; j < array.length; j++) {
                Integer second_number = array[j];
                // if sum of numbers meets the target add to result List
                if (first_number + second_number == target) {
                    results.add(new Integer[]{Math.min(first_number, second_number), Math.max(first_number, second_number)});
                }
            }
        }

        results.sort(Comparator.comparingInt(x -> x[0]));
        results.forEach(pair -> System.out.println(String.format("%d %d", pair)));
    }


}
