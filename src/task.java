import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Piotr Badysiak
 */
public class task {

    //variables
    private static final long RANDOM_STREAM_SIZE = 25000;
    private static final int RANDOM_MIN_BOUND = 0;
    private static final int RANDOM_MAX_BOUND = 1444;

    private static final String DELIMITER = ",";

    /**
     * Prints statistics for List of integers.
     * When executed without filename as first argument, random int stream is used.
     *
     * @param args 0 - filename
     */
    public static void main(String[] args) {
        List<Integer> list;

        //checks whether arguments has been passed
        if (args.length > 0) {
            try {
                list = Files.readAllLines(Paths.get(args[0])) // read all lines from file
                        .parallelStream()
                        .flatMap(line -> Arrays.stream(line.split(DELIMITER)).map(x -> Integer.valueOf(x.trim()))) // flat map list of lines into stream of single integers
                        .collect(Collectors.toList()); // collect to list
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

        printStatistics(list);
    }

    private static void printStatistics(List<Integer> list) {
        //create variable containing count, min , max, avg
        IntSummaryStatistics summaryStatistics = list
                .parallelStream()
                .mapToInt(Integer::intValue) // map to IntStream
                .summaryStatistics();

        //create distinct list sorted ascending order
        List<Integer> distinctList = list
                .parallelStream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(distinctList);
        System.out.println(String.format("Count: %d", summaryStatistics.getCount()));
        System.out.println(String.format("Distinct: %d", distinctList.size()));
        System.out.println(String.format("Min: %d", summaryStatistics.getMin()));
        System.out.println(String.format("Max: %d", summaryStatistics.getMax()));
    }
}
