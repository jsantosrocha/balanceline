# Balance-Line - Compare two files by any key
## Overview

Many times we need to consolidate information that is in two separate files, finding the similarity of the records from both files.

How to do it?

An example solution would be to use Microsoft Excel, loading the files into separate worksheets and using the PROCV function to cross-reference the information.

However, this solution is not always practical. We have to import the files, correctly format the cells and formulas. Often, the file exceeds the Excel limit, making this solution unfeasible.

This program aims to solve this problem by comparing two files (using any key) and saving a new file only with records where the key was found in both files.

## Installation and executing

- Make sure you have Java version 17 or higher.
- Download .JAR file
- Run de program:

`java -jar balanceline.jar <fileIn1> <fileIn2> <fileOut> <posKey> <lengthKey>`

- Description of params:
```
fileIn1....= File in 1
fileIn2....= File in 2
fileOut....= File out
posKey.....= Initial position of key, value must be greater than zero
lengthKey..= Length key, value must be greater than zero
```