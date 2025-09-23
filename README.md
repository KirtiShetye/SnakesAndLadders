Setup instructions:
1. Prerequisites:
    - Java JDK 8+
    - Maven 5.x (for unit testing)
    - IntelliJ IDEA IDE
2. Clone the repository - SnakesAndLadders
    - git clone https://github.com/KirtiShetye/SnakesAndLadders.git

3. Open project in IntelliJ 
    - Start IntelliJ
    - Open cloned project in IntelliJ
      File → New → Project from Existing Sources…
      Select the pom.xml inside cloned folder
      Import as Maven project → choose Yes
      Dependencies will get imported.
    - Menu->Build->Build project
    - Run snakesAndLaddersApp.java
    - Console will open in IntelliJ. Give inputs like 
           87,2
           32,7
           Pune
           exit
    - Right click on directory "src/test/java" ,click on Run All Tests.

Assumptions:
1. Size of board is 100.
2. DiceCount is between 1 to 6, current position is between 0,100.
3. Console input is comma-separated i.e. position,dice or "exit".
4. Invalid inputs (non-integer, out-of-range) has retry mechanism.
5. Position of Snakes and ladders is defined in Board
    Ladders: 3→22, 8→30, 28→84, 56→77
    Snakes: 95→56, 87→24, 30→19, 48→10
6. Handled condition
   - Tail of snake has start of Ladder 
   - Top of ladder has head of snake
7. The game loop runs until the player reaches 100 or exits.