### About

Program reads first line of file for N then reads N lines and parse values to ints (using " " as delimiter - defined in ```DELIMITER``` variable ) Path can be either relative or absolute.

HashSet is used to gather unique ints. If pair is successfully added that means it's a separate graph.

### Task3
The first line of input contains a positive number `n`, next `n` lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph. Please provide a working code that will give us the answer for the following questions: how many separated graphs are in the input.

Sample: 

For the input:

```
3
1 2
2 3
5 6
```

expected output is:

```
2
```

Explanation: first graph contains vertices 1, 2 and 3 while the second one contains 5 and 6.