# SudokuValidator
1. Create a command line tool (running on jvm) for validating a standard 9x9 Sudoku puzzle.

2. Command line: validate.bat puzzleName.txt.

3. File format: csv format each line representing a row e.g.:

1,2,3,4,5,6,7,8,9

1,2,3,4,5,6,7,8,9

1,2,3,4,5,6,7,8,9

1,2,3,4,5,6,7,8,9

1,2,3,4,5,6,7,8,9

1,2,3,4,5,6,7,8,9

1,2,3,4,5,6,7,8,9

1,2,3,4,5,6,7,8,9

1,2,3,4,5,6,7,8,9

4. The program should return 0 (VALID) or non-zero (INVALID) value with an error text on stdout (in case of an invalid solution or file).

5. There should be unit tests covering a range of error conditions and the project should be maven or gradle based. 
   
6. It should be possible to unpack the code from a zip, generate test report, build it and use a batch file to call the code from a packaged jar.

**INSTRUCTION**

_**In order to build, please use**_

mvn clean install

_**In order to generate report**_

mvn surefire-report:report

_**In order to launch**_

Please use validate.bat or validate.sh
