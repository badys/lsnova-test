### About
Program can be run on two modes.

1) Without arguments - It generates random List of Integers with size and bounds defined in parameters
2) With path as first argument - Program reads all lines then parse values to ints (using " " as delimiter - defined in ```DELIMITER``` variable ) Path can be either relative or absolute.

Application uses double loop to go through list of integers and prints pairs that sum is equal to ```TARGET``` variable. First element of pair is always smaller than the other. List is printed in ascending order.

### Task2
Again, the input is a long list of integers. Provide a working code that will find all the pairs (in this integer list) that sum up to 13. Each pair in the output should have first number not greater than the second one and lines should be sorted in an ascending order.

Sample:

For the input:

```
1 2 10 7 5 3 6 6 13 0

```

expected output is:

```
0 13
3 10
6 7
6 7
```