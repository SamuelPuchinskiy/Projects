from py.Graph import Graph
from py.Add_Nodes import Add_Nodes
from py.Add_Heuristics import Add_Heuristics

def Springfield(answer):

    # Creating Graph
    GraphOne = Graph()

    # Getting node values
    Add_Nodes.add_nodes(GraphOne)


    # Getting heuristics values
    if(answer == '1'):
        Add_Heuristics.add_heuristics_1(GraphOne)
    elif(answer == '2'):
        Add_Heuristics.add_heuristics_2(GraphOne)
    elif (answer == '3'):
        Add_Heuristics.add_heuristics_3(GraphOne)
    elif (answer == '4'):
        Add_Heuristics.add_heuristics_4(GraphOne)

    # Getting heuristics values for all options
    elif (answer == '5'):
        # Creating Graph
        GraphTraffic = Graph()
        GraphPopulation = Graph()
        GraphArea = Graph()
        GraphStraightLine = Graph()
        # Getting node values
        Add_Nodes.add_nodes(GraphTraffic)
        Add_Nodes.add_nodes(GraphPopulation)
        Add_Nodes.add_nodes(GraphArea)
        Add_Nodes.add_nodes(GraphStraightLine)

        Add_Heuristics.add_heuristics_1(GraphTraffic)
        Add_Heuristics.add_heuristics_2(GraphPopulation)
        Add_Heuristics.add_heuristics_3(GraphArea)
        Add_Heuristics.add_heuristics_4(GraphStraightLine)

    # Placing cites in an array
    NamesofCitys = ['Bloomington', 'Quincy', 'St. Louis', 'Champaign', 'Mt. Vernon', 'Carbondale', 'Peoria', 'Rockford',
                    'Chicago', 'Freeport', 'Kewanee', 'Chester', 'Vandalia', 'Effingham']

    count = True
    print()
    while count:
        for name in NamesofCitys:
            print(name)

        # Asking user for city input
        print("\nPlease choose a city from the listed above to find the shortest path to Springfield: ")
        StartCity = input("Enter City: ")
        for name in NamesofCitys:
            if name == StartCity:
                count = False
                break
        if count == True:
            print("Invalid output, try again.\nSpelling counts + Capitalize first letter. \n")

    print()

    # Sending data to A Star Algorithm in Graph
    if answer == '5':
        pathTraffic = GraphTraffic.a_star_search(StartCity, ['Springfield'])
        pathPopulatoin = GraphPopulation.a_star_search(StartCity, ['Springfield'])
        pathArea = GraphArea.a_star_search(StartCity, ['Springfield'])
        pathStraightLine = GraphStraightLine.a_star_search(StartCity, ['Springfield'])

        costTraffic = str(pathTraffic[0])
        costPopulation = str(pathPopulatoin[0])
        costArea = str(pathArea[0])
        costStraigtLine = str(pathStraightLine[0])

        if pathTraffic:
            print('\nThe shortest path from ' + StartCity + " to Springfield  according to traffic is:")
            tempstring = ""
            for i, city in enumerate(pathTraffic[1]):
                if (i + 1) is not len(pathTraffic[1]):
                    tempstring += city  + ' -> '
                else:
                    tempstring += city
            print(tempstring)
            print(" With Cost: " + costTraffic)
        else:
            print('\nThere is no path from ' + StartCity + " to Springfield.")

        if pathPopulatoin:
            print('\nThe shortest path from ' + StartCity + " to Springfield  according to Population is:")
            tempstring = ""
            for i, city in enumerate(pathPopulatoin[1]):
                if (i + 1) is not len(pathPopulatoin[1]):
                    tempstring += city + ' -> '
                else:
                    tempstring += city
            print(tempstring)
            print(" With Cost: " + costPopulation)
        else:
            print('\nThere is no path from ' + StartCity + " to Springfield.")

        if pathArea:
            print('\nThe shortest path from ' + StartCity + " to Springfield  according to Area  is:")
            tempstring = ""
            for i, city in enumerate(pathArea[1]):
                if (i + 1) is not len(pathArea[1]):
                    tempstring += city + ' -> '
                else:
                    tempstring += city
            print(tempstring)
            print(" With Cost: " + costArea)
        else:
            print('\nThere is no path from ' + StartCity + " to Springfield.")

        if pathStraightLine:
            print('\nThe shortest path from ' + StartCity + " to Springfield  according to Straight Line  is:")
            tempstring = ""
            for i, city in enumerate(pathStraightLine[1]):
                if (i + 1) is not len(pathStraightLine[1]):
                    tempstring += city + ' -> '
                else:
                    tempstring += city
            print(tempstring)
            print(" With Cost: " + costStraigtLine)
        else:
            print('\nThere is no path from ' + StartCity + " to Springfield.")


    else:
        path = GraphOne.a_star_search(StartCity, ['Springfield'])
        if path:
            cost = path[0]
            print('\nThe shortest path from ' + StartCity + " to Springfield is:" )
            city_str = ""
            for i, city in enumerate(path[1]):
                if (i + 1) is not len(path[1]):
                    city_str += city + ' -> '
                else:
                    city_str += city
            print(city_str)
            print("With Cost of  " + str(cost))
        else:
            print('\nThere is no path from ' + StartCity + " to Springfield.")
