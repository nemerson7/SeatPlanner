
- Author: Nick Emerson
- Date: 3/13/22

### Building

Run "mvn package" from project directory to create jar file,
then run "java -jar ./target/MovieSeatAssigner-1.0-SNAPSHOT-jar-with-dependencies.jar". Run "mvn test" from project directory to run test cases.

### Assumptions

- The ticket reservations should reserve blocks of adjacent seats

- For spacing constraints, the blocks can be either three spaces apart or on a different row. The "one row" is interpreted to mean that the next block is on a different row, since R001 and R004 per the example do not have an additional row separating the two blocks

- The only constraint of the blocks is that they must be adjacently connected, see example below for line carryover for a block of size 6 on a 5x4 board:
\n
xxxxx
\n
----x
\n
-----
\n
-----
\n

- If there is a following group (suppose size 4), it will fill in at the end of the line, preserving spacing of 3 between groups on the same line
\n
xxxxx
\n
o---x
\n
ooo--
\n
-----
\n


- The customer satisfaction criterion is assumed to mean as close to the screen as possible without violating safety constraint


### Design Decisions

- File reading/writing is decoupled from the rest of the program because it has a unique functionality and may necessitate specific changes (such as tokenizing on carriage return chars and newline chars both as opposed to just newlines, depending on the OS)

- Reservation representation was decoupled from the rest of the program because it parses the string read from File IO. The string formatting could change with the problem definition, so this minimizes changes

- Seat arrangement was decoupled from the rest of the program because my choice to use an array as the internal theater seating representation works for the current application, but other structures could be a better fit if the constraints change

- Abstract classes were used to decouple the interfaces for seat reservations, seat arrangements, and the assigner class from their implementation

- String arrays were used to represent movie theater seating because changes to seating size are not anticipated during runtime


### Class Hierarchies

- Main class: aggregates all other classes, takes user input, prints desired output

- FileInterface: Expected interface for implementation class for FileIO

- FileProcessor: Implementation class provided for FileInterface. It is responsible for reading and writing strings to and from persistent storage

- Reservation: Abstract class for implementation class that stores movie reservations

- ReservationHashMap: Implementation class provided for Reservation, utilizes a HashMap to map identifiers and seat counts (an arraylist is also used to guarantee order of identifiers in output matches order of identifiers in input)

- SeatArrangement: Abstract class for implementation class that stores seat arrangements

- SeatArrangementArray: Implementation class for SeatArrangement, utilizes a 2d string array to represent theater seating

- SeatsExceededException: Custom exception for when too many seats reserved


### Future Changes

- Change of input file format: For this we only need to change ReservationHashMap to a different class that implements the Reservation interface

- Concurrency: This would require changes to data structures used to be concurrent versions and added mutexes for file IO, printing to stdout, and modifying shared mutable state. Also if the program is running as a server, this may require us to handle errors more gracefully


