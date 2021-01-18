from py.Graph import Graph
from py.Node import Node

class Add_Heuristics:

    #Traffic base on Commuter Traffic
    def add_heuristics_1(graph):
        graph.add_node_heuristics('Springfield', 0)
        graph.add_node_heuristics('Bloomington', 12)
        graph.add_node_heuristics('Quincy', 2)
        graph.add_node_heuristics('St. Louis', 40)
        graph.add_node_heuristics('Champaign', 7)
        graph.add_node_heuristics('Mt. Vernon', 18)
        graph.add_node_heuristics('Carbondale', 4)
        graph.add_node_heuristics('Peoria', 12)
        graph.add_node_heuristics('Rockford', 39)
        graph.add_node_heuristics('Chicago', 45)

        graph.add_node_heuristics("Freeport", 17)
        graph.add_node_heuristics("Kewanee", 26)
        graph.add_node_heuristics("Vandalia", 5)
        graph.add_node_heuristics("Chester", 6)
        graph.add_node_heuristics("Effingham", 3)

    #Population base on 2010 Census
    def add_heuristics_2(graph):
        graph.add_node_heuristics('Springfield', 0)
        graph.add_node_heuristics('Bloomington', 76610)
        graph.add_node_heuristics('Quincy', 40633)
        graph.add_node_heuristics('St. Louis', 318069)
        graph.add_node_heuristics('Champaign', 81055)
        graph.add_node_heuristics('Mt. Vernon', 15277)
        graph.add_node_heuristics('Carbondale', 25902)
        graph.add_node_heuristics('Peoria', 115007)
        graph.add_node_heuristics('Rockford', 152871)
        graph.add_node_heuristics('Chicago', 2695598)

        graph.add_node_heuristics("Freeport", 25628)
        graph.add_node_heuristics("Kewanee", 12916)
        graph.add_node_heuristics("Vandalia", 6758)
        graph.add_node_heuristics("Chester", 8599)
        graph.add_node_heuristics("Effingham", 12328)

    #Area base on Square Miles
    def add_heuristics_3(graph):
        graph.add_node_heuristics('Springfield', 0)
        graph.add_node_heuristics('Bloomington', 27.22)
        graph.add_node_heuristics('Quincy', 15.91)
        graph.add_node_heuristics('St. Louis', 66)
        graph.add_node_heuristics('Champaign', 22.43)
        graph.add_node_heuristics('Mt. Vernon', 13.07)
        graph.add_node_heuristics('Carbondale', 17.09)
        graph.add_node_heuristics('Peoria', 48.01)
        graph.add_node_heuristics('Rockford', 61.08)
        graph.add_node_heuristics('Chicago', 227.63)

        graph.add_node_heuristics("Freeport", 11.79)
        graph.add_node_heuristics("Kewanee", 6.71)
        graph.add_node_heuristics("Vandalia", 8.1)
        graph.add_node_heuristics("Chester", 5.81)
        graph.add_node_heuristics("Effingham", 9.86)

    #Straight-Line Distance base on www.mapdevelopers.com/distance_from_to.php
    def add_heuristics_4(graph):
        graph.add_node_heuristics('Springfield', 0)
        graph.add_node_heuristics('Bloomington', 57.86)
        graph.add_node_heuristics('Quincy', 94.12)
        graph.add_node_heuristics('St. Louis', 86.28)
        graph.add_node_heuristics('Champaign', 77.35)
        graph.add_node_heuristics('Mt. Vernon', 109.82)
        graph.add_node_heuristics('Carbondale', 144.97)
        graph.add_node_heuristics('Peoria', 61.90)
        graph.add_node_heuristics('Rockford', 173.21)
        graph.add_node_heuristics('Chicago', 178.12)

        graph.add_node_heuristics("Freeport", 172.58)
        graph.add_node_heuristics("Kewanee", 101.03)
        graph.add_node_heuristics("Vandalia", 64.96)
        graph.add_node_heuristics("Chester", 130.62)
        graph.add_node_heuristics("Effingham", 75.14)
