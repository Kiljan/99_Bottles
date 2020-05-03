# 99 Bottles project

## Reason for creation (problem)
Compilers on similar to hackerrank web sites either do not match the syntax or do not use Java8+

## In search of a solution to a problem
There are 99 programming problems to solve on [Mr. Werner Hett's](https://sites.google.com/site/prologsite/author ) website. I believe that all of them can be successfully solved with the help of new functionalities offered by Java8.

Additional information can be found on the [website](https://sites.google.com/site/prologsite/prolog-course/a-first-glimpse) created by Mr. Werner.

## Approach to testing
These are the basic tests written in JUnit4 to check the basic assumptions of the problems. In the first three examples I was still checking if the lists were empty or not giving try catch blocks in solutions. By assumption, however, this is not an application but individual challenges. That is why I gave up this approach to make the solution code as simple as possible.

## Technologies
* Java8
* JUnit4
* Eclipse

## Kind of right changes
* __Bottle 09, Bottle 10, Bottle 11, Bottle 12, Bottle 13__<br> collects information about all duplicates. Uses function interface and map of all elements. __Bottle 13 == Bottle 11__
* __Bottle 16__ without streams is definitely simpler
* cdn..
