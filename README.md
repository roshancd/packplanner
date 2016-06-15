# packplanner
pack planner is a simple application which takes list of items and sort them into several packs (groups)

To use the pack planner please follow the steps below:

(1) Checkout the source code by cloning the repository with url
    [https://github.com/roshancd/packplanner.git]

(2) Go inside the project root folder (packplanner).

(3) To compile the project execute the following command
    [mvn clean install]

(4) To run the application, run the command below.
    [mvn exec:java]

    To run the application with jar file follow the steps below.
        - Find the generated jar file "pack-planner-1.1.0-SNAPSHOT.jar" inside the "target" folder
        - Run the command [java -jar pack-planner-1.1.0-SNAPSHOT.jar]

(5) Enter your data in the format below and at the end enter empty line (press enter key).

    [Sort order] [max pieces per pack] [max weight per pack]
    [item id],[item length],[item quantity],[piece weight]
    [item id],[item length],[item quantity],[piece weight]
    [item id],[item length],[item quantity],[piece weight]

    Sample Data : LONG_TO_SHORT,20,350.0
                  1001,6200,30,9.653
                  2001,5200,50,1.21
                  3001,2200,50,111.21
                  4001,1200,50,121.21
                  5001,200,50,32.21
                  6001,8200,50,41.21
                  7001,9200,50,16.21

(6) Result will be displayed in following format.

    Pack number: [pack number]
    [item id],[item length],[item quantity],[piece weight]
    [item id],[item length],[item quantity],[piece weight]
    ...
    Pack Length: [pack length], Pack Weight: [pack weight]

    Sample Output : ==================================================
                    ================== Pack Planner ==================
                    ==================================================
                    Pack Number: 1
                    7001,9200.0,50,16.21

                    Pack Length: 9200.0m,Pack Weight: 149.13199kg
                    --------------------------------------------------
                    Pack Number: 2
                    6001,8200.0,50,41.21

                    Pack Length: 8200.0m,Pack Weight: 337.922kg
                    --------------------------------------------------
                    Pack Number: 3
                    1001,6200.0,30,9.653

                    2001,5200.0,50,1.21

                    3001,2200.0,50,111.21

                    Pack Length: 13600.0m,Pack Weight: 310.8026kg
                    --------------------------------------------------
                    Pack Number: 4
                    4001,1200.0,50,121.21

                    5001,200.0,50,32.21

                    Pack Length: 1400.0m,Pack Weight: 151.89401kg
                    --------------------------------------------------


(7) Happy coding...!

