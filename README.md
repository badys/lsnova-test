### About
Application build using Java 8 Stream Api.
Program can be run on two modes.

1) Without arguments - It generates random List of Integers with size and bounds defined in parameters
2) With path as first argument - Program reads all lines then parse values to ints (using "," as delimiter - defined in ```DELIMITER``` variable ) Path can be either relative or absolute.

For statistics purposes (count, avg, min, max) IntSummaryStatistics class has been used.

### Task1
The input is a long list of integers. Please write a small app that will output the list of distinct elements sorted in ascending order, plus the basic measurement information that contains the number of elements in the source, number of distinct elements, min and max value.

Sample:

For the input:

```
1 10 20 20 2 5
```

expected output is: 

```
1 2 5 10 20
count: 6
distinct: 5
min: 1
max: 20
```